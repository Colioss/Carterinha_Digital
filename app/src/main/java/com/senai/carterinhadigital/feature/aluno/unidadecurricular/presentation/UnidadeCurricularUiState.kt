package com.senai.carterinhadigital.feature.aluno.unidadecurricular.presentation

import com.senai.carterinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)