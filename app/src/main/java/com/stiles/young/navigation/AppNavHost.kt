package com.stiles.young.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stiles.young.ui.theme.screens.authentication.forgotpassword.ForgotPasswordScreen
import com.stiles.young.ui.theme.screens.authentication.login.LoginScreen
import com.stiles.young.ui.theme.screens.authentication.signup.SignUpScreen
import com.stiles.young.ui.theme.screens.onboarding.OnboardingScreen
import com.stiles.young.ui.theme.screens.onboarding.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ROUTE_ONBOARDING) {
            OnboardingScreen(navController = navController, modifier = modifier)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(
                navController = navController,
                onNavigateToForgotPassword = { navController.navigate(ROUTE_FORGOT_PASSWORD) }
            )
        }
        composable(ROUTE_SIGNUP) {
            SignUpScreen(navController = navController)
        }
        composable(ROUTE_FORGOT_PASSWORD) {
            ForgotPasswordScreen(navController = navController)
        }
    }
}
