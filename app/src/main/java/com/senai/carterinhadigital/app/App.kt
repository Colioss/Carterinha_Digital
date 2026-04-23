package com.senai.carterinhadigital.app

import androidx.compose.runtime.Composable
import com.senai.carterinhadigital.app.navigation.AppNavHost
import com.senai.carterinhadigital.ui.theme.CarteirinhaDigitalTheme

@Composable
fun App() {
    CarteirinhaDigitalTheme() {
        AppNavHost()

    }
}