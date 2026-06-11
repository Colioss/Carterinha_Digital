package com.senai.carterinhadigital.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.senai.carterinhadigital.feature.auth.navigation.authScreen
import com.senai.carterinhadigital.feature.carteirinha.navigation.carteirinhaScreen
import com.senai.carterinhadigital.feature.home.presentation.navigation.homeScreen
import com.senai.carterinhadigital.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        authScreen(navController)

        homeScreen(
            onNavigateToCarteirinha = {
                navController.navigate(Routes.Carteirinha)
            },
            onNavigateToUnidadeCurricular = {
                navController.navigate(Routes.UnidadeCurricular)
            }
        )

        carteirinhaScreen(
            onNavigateToLogin = {
                navController.navigate(Routes.Login)
            }
        )

        composable(Routes.UnidadeCurricular) {
            UnidadeCurricularScreen()
        }
    }
}