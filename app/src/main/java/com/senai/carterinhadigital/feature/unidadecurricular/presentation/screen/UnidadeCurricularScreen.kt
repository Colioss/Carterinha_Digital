package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularViewModel

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    UnidadeCurricularContent(
        uiState = uiState,
        onRetry = { viewModel.carregar() },
        modifier = modifier
    )
}
