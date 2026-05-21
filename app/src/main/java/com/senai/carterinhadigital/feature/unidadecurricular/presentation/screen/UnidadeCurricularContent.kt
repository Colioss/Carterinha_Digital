package com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.component.UnidadeCurricularCard

@Composable
fun UnidadeCurricularContent(modifier : Modifier = Modifier, unidadesCurriculares: List<UnidadeCurricular>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {items (unidadesCurriculares) { unidadeCurricular ->
        UnidadeCurricularCard(unidadeCurricular = unidadeCurricular)
    }
    }
} @Preview(
    showBackground = true,
    showSystemUi = true
)@Composable
fun UnidadeCurricularContentPreview() {
  UnidadeCurricularContent(
      unidadesCurriculares = listOf(
          UnidadeCurricular(id = "1", nome = "Matemática", professor = "Dr. Silva", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 2),
          UnidadeCurricular(id = "2", nome = "Português", professor = "Dr. Pablo", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 0),
          UnidadeCurricular(id = "3", nome = "História", professor = "Dr. Hamood", nota1 = 8.5, nota2 = 7.0, media = 7.75, faltas = 1)
  ) )
}