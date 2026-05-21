package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.feature.unidadecurricular.data.dataSource
import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier
) {
    val unidadesCurriculares = dataSource()
    UnidadeCurricularContent(
        unidadesCurriculares = unidadesCurriculares
    )
}