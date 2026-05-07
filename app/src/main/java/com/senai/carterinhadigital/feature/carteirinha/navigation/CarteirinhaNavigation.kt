package com.senai.carterinhadigital.feature.carteirinha.navigation

import com.senai.carterinhadigital.feature.carteirinha.presentation.CarteirinhaScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carterinhadigital.app.navigation.Routes

fun NavGraphBuilder.carteirinhaScreen(
    onNavigateToLogin: () -> Unit
) {
    composable(Routes.Carteirinha) {
        CarteirinhaScreen(
            onBackClick = onNavigateToLogin
        )
    }
}