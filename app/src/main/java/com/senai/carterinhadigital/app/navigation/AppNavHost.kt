package com.senai.carterinhadigital.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.senai.carterinhadigital.feature.auth.navigation.authScreen
import com.senai.carterinhadigital.feature.carteirinha.navigation.carteirinhaScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        authScreen(
             navController
        )
        carteirinhaScreen(
            onNavigateToLogin = {
                navController.navigate(Routes.Login)
            }
        )
    }
}