package pe.com.soda.testapp.presentation

import pe.com.soda.testapp.domain.model.Category

sealed interface CategoryUiState {

    data object Loading: CategoryUiState

    data class Success(val categories: List<Category>) : CategoryUiState

    data class Error(val message: String) : CategoryUiState
}