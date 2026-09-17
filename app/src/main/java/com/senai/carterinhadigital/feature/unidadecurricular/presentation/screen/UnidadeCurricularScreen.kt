package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinhadigital.feature.unidadecurricular.data.dataSource
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularViewModel

// 1. IMPORTANTE: Precisamos importar a UnidadeCurricularContent para a Screen reconhecer ela
// Como ela está na mesma pasta (screen), o import deve ser bem parecido com este:
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularContent

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    viewModel: UnidadeCurricularViewModel = viewModel(),
    token: String
) {
    // Pega a lista de dados do seu dataSource
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(token){
        viewModel.carregar(token)
    }
    // Passa a lista para o Content que vai desenhar a tela de fato
    UnidadeCurricularContent(
        unidadesCurriculares = unidadesCurriculares
    )
}