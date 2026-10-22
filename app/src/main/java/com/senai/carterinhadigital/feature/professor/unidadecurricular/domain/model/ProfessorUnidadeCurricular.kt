package com.senai.carterinhadigital.feature.professor.unidadecurricular.domain.model

data class ProfessorUnidadeCurricular(
    val id: Long,
    val nome: String,
    val turmaId: Long,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)
