package com.senai.carterinhadigital.feature.aluno.carteirinha.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.R

@Composable
fun PerfilAluno(
    nome: String,
    matricula: String,
    curso: String,
    idFoto: Int = R.drawable.perfilgatinho
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Image(
            painter = painterResource(id = idFoto),
            contentDescription = "Foto do aluno",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        InfoAluno(
            label = "Nome:",
            value = nome,
            corSombra = Color.Red
        )

        InfoAluno(
            label = "Matrícula:",
            value = matricula,
            corSombra = Color.Red
        )

        InfoAluno(
            label = "Curso:",
            value = curso,
            corSombra = Color.Blue
        )
    }
}
