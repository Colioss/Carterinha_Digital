package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularUiState
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularContent(
    uiState: UnidadeCurricularUiState,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val errorMessage = uiState.errorMessage

    when {
        uiState.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        errorMessage != null -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    onClick = onRetry
                ) {
                    Text("Tentar novamente")
                }
            }
        }

        uiState.unidades.isEmpty() -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Nenhuma unidade curricular encontrada.")
            }
        }

        else -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = uiState.unidades,
                    key = { it.id }
                ) { unidadeCurricular ->
                    UnidadeCurricularCard(
                        unidadeCurricular = unidadeCurricular
                    )
                }
            }
        }
    }
}
