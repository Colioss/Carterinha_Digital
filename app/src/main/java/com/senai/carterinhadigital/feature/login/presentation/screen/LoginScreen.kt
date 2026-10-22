package com.senai.carterinhadigital.feature.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senai.carterinhadigital.feature.login.domain.model.UsuarioLogado
import com.senai.carterinhadigital.feature.login.presentation.LoginEvent
import com.senai.carterinhadigital.feature.login.presentation.LoginViewModel

@Composable
fun LoginScreen(
    onLoginSucesso: (UsuarioLogado) -> Unit,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    onDarkThemeChange: (Boolean) -> Unit = {},
    viewModel: LoginViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }

    LoginContent(
        uiState = uiState,
        onEvent = viewModel::onEvent,
        darkTheme = darkTheme,
        onDarkThemeChange = onDarkThemeChange,
        modifier = modifier
    )
}
