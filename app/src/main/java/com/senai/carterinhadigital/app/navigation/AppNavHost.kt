package com.senai.carterinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carterinhadigital.app.di.AppContainer
import com.senai.carterinhadigital.app.session.SessionViewModel
import com.senai.carterinhadigital.app.session.SessionViewModelFactory
import com.senai.carterinhadigital.app.ui.AppShell
import com.senai.carterinhadigital.feature.carteirinha.presentation.CarteirinhaScreen
import com.senai.carterinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carterinhadigital.feature.login.presentation.LoginViewModel
import com.senai.carterinhadigital.feature.login.presentation.factory.LoginViewModelFactory
import com.senai.carterinhadigital.feature.login.presentation.screen.LoginScreen
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.UnidadeCurricularViewModel
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    container: AppContainer
) {

    val sessionFactory = remember(container.sessionTokenStore) {
        SessionViewModelFactory(
            sessionTokenStore = container.sessionTokenStore
        )
    }

    val sessionViewModel: SessionViewModel =
        viewModel(factory = sessionFactory)

    val usuarioLogado by sessionViewModel.usuarioLogado
        .collectAsStateWithLifecycle()

    val usuario = usuarioLogado

    fun logout() {
        sessionViewModel.limparSessao()

        navController.navigate(Routes.Login.route) {
            popUpTo(Routes.HomeAluno.route) {
                inclusive = true
            }

            launchSingleTop = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {

        // LOGIN
        composable(Routes.Login.route) {

            val loginFactory = remember(container.loginRepository) {
                LoginViewModelFactory(
                    repository = container.loginRepository
                )
            }

            val loginViewModel: LoginViewModel =
                viewModel(factory = loginFactory)

            LoginScreen(
                viewModel = loginViewModel,
                darkTheme = darkTheme,
                onDarkThemeChange = onDarkThemeChange,
                onLoginSucesso = { usuario ->
                    sessionViewModel.setUsuarioLogado(usuario)

                    navController.navigate(Routes.HomeAluno.route) {

                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        // HOME
        composable(Routes.HomeAluno.route) {

            if (usuario == null) {

                RedirecionarParaLogin(navController)

            } else {

                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = {
                        logout()
                    }
                ) { innerPadding ->

                    HomeScreen(
                        navController = navController,
                        usuarioLogado = usuario,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        // CARTEIRINHA
        composable(Routes.Carteirinha.route) {

            if (usuario == null) {

                RedirecionarParaLogin(navController)

            } else {

                AppShell(
                    title = "Carteirinha",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onLogout = {
                        logout()
                    }
                ) { innerPadding ->

                    CarteirinhaScreen(
                        usuarioLogado = usuario,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        // UNIDADES CURRICULARES
        composable(Routes.UCAluno.route) {

            if (usuario == null) {

                RedirecionarParaLogin(navController)

            } else {

                val ucFactory = remember(
                    container.unidadeCurricularRepository
                ) {
                    UnidadeCurricularViewModelFactory(
                        repository = container.unidadeCurricularRepository
                    )
                }

                val ucViewModel: UnidadeCurricularViewModel =
                    viewModel(factory = ucFactory)

                AppShell(
                    title = "Unidades Curriculares",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onLogout = {
                        logout()
                    }
                ) { innerPadding ->

                    UnidadeCurricularScreen(
                        viewModel = ucViewModel,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun RedirecionarParaLogin(
    navController: NavHostController
) {
    LaunchedEffect(Unit) {

        navController.navigate(Routes.Login.route) {

            popUpTo(Routes.HomeAluno.route) {
                inclusive = true
            }

            launchSingleTop = true
        }
    }
}