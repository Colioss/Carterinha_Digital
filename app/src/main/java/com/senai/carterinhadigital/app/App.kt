package com.senai.carterinhadigital.app

import androidx.compose.runtime.Composable
import com.senai.carterinhadigital.app.navigation.AppNavHost
import com.senai.carterinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App() {
    CarteirinhaDigitalTheme() {
        AppNavHost()
    }
}