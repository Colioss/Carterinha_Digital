package com.senai.carterinhadigital.feature.professor.turma.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinhadigital.feature.professor.turma.presentation.TurmaViewModel

@Composable
fun TurmaScreen(
    modifier: Modifier = Modifier,
    viewModel: TurmaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.carregar()
    }

    TurmaContent(
        uiState = uiState,
        onRetry = { viewModel.carregar() },
        modifier = modifier
    )
}
