package com.senai.carterinhadigital.feature.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carterinhadigital.app.navigation.Routes

import com.senai.carterinhadigital.feature.home.presentation.screen.homeScreen as HomeView

fun NavGraphBuilder.homeScreen(
    onNavigateToCarteirinha: () -> Unit,
    onNavigateToUnidadeCurricular: () -> Unit
) {
    composable(Routes.Home) {

        HomeView(
            onCarteirinhaClick = onNavigateToCarteirinha,
            onUnidadeCurricularClick = onNavigateToUnidadeCurricular
        )
    }
}