package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.senai.carterinhadigital.feature.unidadecurricular.data.dataSource

// 1. IMPORTANTE: Precisamos importar a UnidadeCurricularContent para a Screen reconhecer ela
// Como ela está na mesma pasta (screen), o import deve ser bem parecido com este:
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularContent

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier
) {
    // Pega a lista de dados do seu dataSource
    val unidadesCurriculares = dataSource()

    // Passa a lista para o Content que vai desenhar a tela de fato
    UnidadeCurricularContent(
        unidadesCurriculares = unidadesCurriculares
    )
}