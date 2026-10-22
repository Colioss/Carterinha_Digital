package com.senai.carterinhadigital.feature.professor.turma.presentation

import com.senai.carterinhadigital.feature.professor.turma.domain.model.Turma

data class TurmaUiState(
    val isLoading: Boolean = false,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)
