package com.senai.carterinhadigital.feature.aluno.unidadecurricular.domain.repository

import com.senai.carterinhadigital.feature.aluno.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}