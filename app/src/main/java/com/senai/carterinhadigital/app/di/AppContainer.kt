package com.senai.carterinhadigital.app.di

import com.senai.carterinhadigital.core.auth.SessionTokenStore
import com.senai.carterinhadigital.feature.login.data.repository.LoginRepository
import com.senai.carterinhadigital.feature.unidadecurricular.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : UnidadeCurricularRepository
}