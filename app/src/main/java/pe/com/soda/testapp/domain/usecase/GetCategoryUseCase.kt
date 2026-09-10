package pe.com.soda.testapp.domain.usecase

import pe.com.soda.testapp.domain.model.Category
import pe.com.soda.testapp.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): List<Category> {
        return categoryRepository.getCategories()
    }
}