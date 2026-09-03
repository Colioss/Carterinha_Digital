package com.senai.carterinhadigital.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carterinhadigital.app.navigation.AppNavHost
import com.senai.carterinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App() {
    CarteirinhaDigitalTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
        )
    }
}