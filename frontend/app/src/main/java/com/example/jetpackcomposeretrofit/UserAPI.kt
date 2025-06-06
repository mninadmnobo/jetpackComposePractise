package com.example.jetpackcomposeretrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

    @POST("/login")
    suspend fun login(@Body user: User): Response<LoginResponse>
}