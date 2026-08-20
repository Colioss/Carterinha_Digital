package com.senai.carterinhadigital.feature.login.data.repository

import com.senai.carterinhadigital.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(usuario:String, senha:String): Result<UsuarioLogado>
}