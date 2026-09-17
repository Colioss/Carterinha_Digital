package com.senai.carterinhadigital.feature.unidadecurricular.data.repository

import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listarUnidades(
        token: String
    ): Result<List<UnidadeCurricular>>
}