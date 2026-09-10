package pe.com.soda.testapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pe.com.soda.testapp.domain.model.Category
import pe.com.soda.testapp.domain.usecase.GetCategoryUseCase
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    init {
        getCategories()
    }

    fun getCategories() = viewModelScope.launch {
        _uiState.value = CategoryUiState.Loading

        try {
            val categories: List<Category> = getCategoryUseCase()
            _uiState.value = CategoryUiState.Success(categories = categories)
        } catch (exception: Exception) {
            _uiState.value = CategoryUiState.Error(
                message = exception.message ?: "No se pudo cargar las categorias"
            )
        }
    }

}