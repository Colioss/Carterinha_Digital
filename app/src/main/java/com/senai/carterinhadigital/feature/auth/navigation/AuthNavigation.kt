package com.senai.carterinhadigital.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.senai.carterinhadigital.app.navigation.Routes
import com.senai.carterinhadigital.feature.auth.presentation.LoginScreen

fun NavGraphBuilder.authScreen(
    navController: NavController
) {
    composable(Routes.Login) {
        LoginScreen(
            navController = navController
        )
    }
}
