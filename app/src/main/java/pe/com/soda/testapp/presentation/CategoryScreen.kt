package pe.com.soda.testapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.com.soda.testapp.domain.model.Category

@Composable
fun CategoryScreen(
    uiState: CategoryUiState,
) {
    Scaffold { paddingValues ->
        when(uiState) {
            CategoryUiState.Loading -> LoadingContent(Modifier.padding(paddingValues))
            is CategoryUiState.Success -> {
                CategoryContent(
                    categories = uiState.categories,
                    modifier = Modifier.padding(paddingValues)
                )
            }
            is CategoryUiState.Error -> {
                ErrorContent(
                    message = uiState.message,
                    modifier = Modifier.padding(paddingValues),
                )
            }
        }
    }
}


@Composable
fun CategoryContent(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = categories,
            key = { category -> category.name }
        ) { category ->

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = category.name,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}

@Composable
fun LoadingContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun ErrorContent(
    message: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Error",
        )
        Text(
            text = message,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}