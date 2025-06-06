package com.example.jetpackcomposeretrofit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DashboardScreen(username: String) {
    Text("Hello $username")
}