package pe.com.soda.testapp.data.repository

import pe.com.soda.testapp.data.mappers.toDomain
import pe.com.soda.testapp.data.remote.ChuckNorrisApi
import pe.com.soda.testapp.domain.model.Category
import pe.com.soda.testapp.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val chuckNorrisApi: ChuckNorrisApi,
): CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return chuckNorrisApi
            .getCategories()
            .map { category -> category.toDomain() }
    }
}