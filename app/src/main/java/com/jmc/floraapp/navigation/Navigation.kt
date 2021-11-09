package com.jmc.floraapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jmc.floraapp.view.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.HomeScreen.route) {
            Dashboard(navController = navController)
        }

        composable(Screen.DetailScreen.route) {
            DetailScreen(navController = navController)
        }

        composable(Screen.ListScreen.route) {
            ListScreen(navController = navController)
        }

        composable(Screen.CheckoutScreen.route) {
            CheckoutScreen(navController = navController)
        }
    }
}