package com.senai.carterinhadigital.app.di

import com.senai.carterinhadigital.core.auth.SessionTokenStore
import com.senai.carterinhadigital.core.network.NetworkClient
import com.senai.carterinhadigital.feature.login.data.remote.service.AuthApi
import com.senai.carterinhadigital.feature.login.data.repository.ApiAuthRepositoryImpl
import com.senai.carterinhadigital.feature.login.data.repository.FakeLoginRepositoryImpl
import com.senai.carterinhadigital.feature.login.data.repository.LoginRepository
import com.senai.carterinhadigital.feature.unidadecurricular.data.remote.service.UnidadeCurricularApi
import com.senai.carterinhadigital.feature.unidadecurricular.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carterinhadigital.feature.unidadecurricular.domain.repository.UnidadeCurricularRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore : SessionTokenStore = SessionTokenStore()
    private val networkClient =
        NetworkClient(
            baseUrl = BASE_URL,
            sessionTokenStore = sessionTokenStore
        )

    private val authApi : AuthApi by lazy {
        networkClient.createPublic(
            AuthApi::class.java
        )
    }
    private val unidadeCurricularApi : UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            UnidadeCurricularApi::class.java
        )
    }
    override val loginRepository : LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY ) {
            FakeLoginRepositoryImpl()
        } else {
            ApiAuthRepositoryImpl(
                api = authApi
            )
        }
    }
    override val unidadeCurricularRepository : UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }
    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}