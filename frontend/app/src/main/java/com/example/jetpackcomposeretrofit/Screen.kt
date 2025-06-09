package com.example.jetpackcomposeretrofit

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Initial: Screen()
    @Serializable
    data object Login: Screen()
    @Serializable
    data object AllUsers: Screen()
    @Serializable
    data class Dashboard(val username: String): Screen()
}