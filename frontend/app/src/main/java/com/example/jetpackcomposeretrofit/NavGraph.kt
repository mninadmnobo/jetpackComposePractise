package com.example.jetpackcomposeretrofit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Initial) {
        composable<Screen.Initial> {
            InitialScreen(navigateToLogin = {
                navController.navigate(Screen.Login)
            })
        }
        composable<Screen.Login> {
            LoginScreen(navigateToAllUsersScreen = {
                navController.navigate(Screen.AllUsers)
            }, navigateToDashboard = { username ->
                navController.navigate(Screen.Dashboard(username))
            })
        }
        composable<Screen.AllUsers> {
            AllUsersScreen(navigateToLoginPage = {
                navController.navigate(Screen.Login)
            })
        }
        composable<Screen.Dashboard> { backStackEntry ->
            val (username) = backStackEntry.toRoute<Screen.Dashboard>()
            DashboardScreen(username)
        }
    }
}
