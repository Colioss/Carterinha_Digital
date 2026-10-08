package com.senai.carterinhadigital.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.senai.carterinhadigital.app.di.AppContainer
import com.senai.carterinhadigital.app.navigation.AppNavHost
import com.senai.carterinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun App(container: AppContainer) {
    var darkTheme by remember { mutableStateOf(false) }
    CarteirinhaDigitalTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            AppNavHost(
                navController = navController,
                darkTheme = darkTheme,
                onDarkThemeChange = { darkTheme = it },
                container = container
            )
        }
    }
}
