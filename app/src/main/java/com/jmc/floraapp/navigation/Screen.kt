package com.jmc.floraapp.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("details_screen")
    object ListScreen : Screen("list_screen")
    object CheckoutScreen : Screen("checkout_screen")
}