package com.senai.carterinhadigital.feature.unidadecurricular.data.repository

import com.senai.carterinhadigital.feature.login.data.remote.network.NetworkFactory
import com.senai.carterinhadigital.feature.unidadecurricular.domain.repository.UnidadeCurricularRepository

object UnidadeCurricularRepositoryProvider {
    fun provide(): UnidadeCurricularRepository {
        return ApiUnidadeCurricularRepositoryImpl(
            NetworkFactory.createUnidadeCurricularApi()
        )
    }
}