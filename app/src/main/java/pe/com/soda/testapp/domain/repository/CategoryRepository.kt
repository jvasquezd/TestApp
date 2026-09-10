package pe.com.soda.testapp.domain.repository

import pe.com.soda.testapp.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories(): List<Category>
}