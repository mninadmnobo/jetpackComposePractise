package com.example.jetpackcomposeretrofit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun LoginScreen(
    navigateToAllUsersScreen: () -> Unit,
    navigateToDashboard: (username: String) -> Unit
) {

    var username by remember { mutableStateOf(("")) }
    var password by remember { mutableStateOf("") }
    var errorMessage: String? by remember { mutableStateOf(null) }

    Column {
        Button(onClick = navigateToAllUsersScreen) {
            Text("Go to all users screen")
        }

        TextField(value = username, onValueChange = { newUsername ->
            username = newUsername
        }, label = {
            Text("Username")
        }, singleLine = true)

        TextField(value = password, onValueChange = { newPassword ->
            password = newPassword
        }, label = {
            Text("Password")
        }, singleLine = true, visualTransformation = PasswordVisualTransformation())

        Button(onClick = {

            CoroutineScope(Dispatchers.IO).launch {
                val (success) = RetrofitInstance.api.login(User(username, password)).body()!!
                if (!success) {
                    errorMessage = "Username or password does not exist"
                }
                else {
                    withContext(Dispatchers.Main) {
                        navigateToDashboard(username)
                    }

                }
            }

        }) {
            Text("Login")
        }

        if (errorMessage != null) {
            Text(errorMessage!!)
        }
    }
}