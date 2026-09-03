package com.senai.carterinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carterinhadigital.app.session.SessionViewModel
import com.senai.carterinhadigital.feature.carteirinha.presentation.CarteirinhaScreen
import com.senai.carterinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carterinhadigital.feature.login.presentation.screen.LoginScreen
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel= viewModel()
) {
    val usuarioLogado by sessionViewModel.usuarioLogador.collectAsStateWithLifecycle()
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(
                onLoginSucesso = {
                        usuario ->
                    sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.HomeAluno.route)
                }
            )
        }
        composable(Routes.Carteirinha.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
        composable(Routes.HomeAluno.route) {
            val usuario = usuarioLogado
            if(usuario == null){
                LaunchedEffect(Unit) {
                    navController.navigate((Routes.Login.route))
                }
            }else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        usuarioLogado = usuario
                    )
                }
            }
        }
        composable(Routes.UCAluno.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UnidadeCurricularScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}