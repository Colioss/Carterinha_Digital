package com.senai.carterinhadigital.feature.unidadecurricular.domain.repository

import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}