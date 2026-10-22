package com.senai.carterinhadigital.feature.aluno.unidadecurricular.data.repository

import com.senai.carterinhadigital.feature.login.data.remote.network.NetworkFactory
import com.senai.carterinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository

object UnidadeCurricularRepositoryProvider {
    fun provide(): com.senai.carterinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository {
        return _root_ide_package_.com.senai.carterinhadigital.feature.aluno.unidadecurricular.data.repository.ApiUnidadeCurricularRepositoryImpl(
            NetworkFactory.createUnidadeCurricularApi()
        )
    }
}