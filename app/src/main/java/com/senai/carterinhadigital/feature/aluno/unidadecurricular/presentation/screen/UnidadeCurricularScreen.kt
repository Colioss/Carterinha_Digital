package com.senai.carterinhadigital.feature.aluno.unidadecurricular.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularViewModel

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: com.senai.carterinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    _root_ide_package_.com.senai.carterinhadigital.feature.aluno.unidadecurricular.presentation.screen.UnidadeCurricularContent(
        uiState = uiState,
        onRetry = { viewModel.carregar() },
        modifier = modifier
    )
}
