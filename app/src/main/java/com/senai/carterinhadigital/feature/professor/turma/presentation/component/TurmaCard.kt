package com.senai.carterinhadigital.feature.professor.turma.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.feature.professor.turma.domain.model.Turma

@Composable
fun TurmaCard(
    turma: Turma,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = turma.codigo,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Semestre: ${turma.semestre}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = turma.curso,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Alunos: ${turma.quantidadeAlunos}",
                style = MaterialTheme.typography.bodyMedium
            )

            if (turma.diasSemana.isNotEmpty()) {
                Text(
                    text = "Dias: ${turma.diasSemana.joinToString(", ")}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            if (turma.horarioInicio.isNotBlank() && turma.horarioFim.isNotBlank()) {
                Text(
                    text = "Horário: ${turma.horarioInicio} - ${turma.horarioFim}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
