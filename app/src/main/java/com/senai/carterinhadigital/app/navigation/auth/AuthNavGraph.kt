package com.senai.carterinhadigital.app.navigation.auth

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senai.carterinhadigital.app.navigation.GraphRoutes
import com.senai.carterinhadigital.feature.login.data.repository.LoginRepository
import com.senai.carterinhadigital.feature.login.domain.model.UsuarioLogado
import com.senai.carterinhadigital.feature.login.presentation.LoginViewModel
import com.senai.carterinhadigital.feature.login.presentation.factory.LoginViewModelFactory
import com.senai.carterinhadigital.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(
    loginRepository: LoginRepository,
    darkTheme: Boolean = false,
    onDarkThemeChange: (Boolean) -> Unit = {},
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    navigation(
        startDestination = AuthRoutes.LOGIN,
        route = GraphRoutes.AUTH
    ) {
        composable(route = AuthRoutes.LOGIN) {
            val factory = remember(loginRepository) {
                LoginViewModelFactory(
                    repository = loginRepository
                )
            }

            val loginViewModel: LoginViewModel = viewModel(
                factory = factory
            )

            LoginScreen(
                viewModel = loginViewModel,
                darkTheme = darkTheme,
                onDarkThemeChange = onDarkThemeChange,
                onLoginSucesso = onLoginSucesso
            )
        }
    }
}
