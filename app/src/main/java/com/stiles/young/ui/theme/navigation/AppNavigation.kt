package com.stiles.young.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stiles.young.ui.theme.screens.authentication.login.LoginScreen
import com.stiles.young.ui.theme.screens.onboarding.OnboardingScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = ROUTES.Onboarding.name,
        modifier = modifier
    ) {
        composable(ROUTES.Onboarding.name) { OnboardingScreen(navController, modifier) }
        composable(ROUTES.Login.name) { }
        composable(ROUTES.ForgotPassword.name) { LoginScreen() { }}
        composable(ROUTES.Register.name) { }
        composable(ROUTES.Home.name) { }
    }
}
