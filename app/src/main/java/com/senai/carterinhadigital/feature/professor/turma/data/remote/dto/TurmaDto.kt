package com.senai.carterinhadigital.feature.professor.turma.data.remote.dto

import com.senai.carterinhadigital.feature.professor.turma.domain.model.Turma
import kotlinx.serialization.Serializable

@Serializable
data class TurmaDto(
    val id: Long,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String> = emptyList(),
    val horarioInicio: String = "",
    val horarioFim: String = ""
) {
    fun toDomain(): Turma {
        return Turma(
            id = id,
            codigo = codigo,
            curso = curso,
            semestre = semestre,
            quantidadeAlunos = quantidadeAlunos,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}
