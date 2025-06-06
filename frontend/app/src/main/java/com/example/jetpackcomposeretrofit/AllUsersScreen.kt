package com.example.jetpackcomposeretrofit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun AllUsersScreen(navigateToLoginPage: () -> Unit) {

    var users: List<User>? by remember { mutableStateOf(null) }

    LaunchedEffect(key1 = null) {
        users = RetrofitInstance.api.getUsers().body()
    }

    Column {
        if (users != null) {
            for (user in users!!) {
                UserCard(user)
            }
        }
        Button(onClick = navigateToLoginPage) {
            Text("Go to Login page")
        }
    }

}

@Composable
fun UserCard(user: User) {
    val (username, password) = user
    Text("Username $username, Password: $password")
}