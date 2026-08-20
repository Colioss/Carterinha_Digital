package com.senai.carterinhadigital.feature.login.presentation

import com.senai.carterinhadigital.feature.login.domain.model.UsuarioLogado

data class LoginUiState(
    val usuario: String ="",
    val senha: String="",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val usuarioLogado: UsuarioLogado? = null

){
    val loginRealizado: Boolean
        get() = usuarioLogado != null
}