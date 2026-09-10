package com.example.realestatefinder.data.repository

import com.example.realestatefinder.data.model.LoginRequest
import com.example.realestatefinder.data.model.RegisterRequest
import com.example.realestatefinder.data.remote.RetrofitInstance

class AuthRepository {

    suspend fun login(email: String, password: String) =
        RetrofitInstance.api.login(LoginRequest(email, password))

    suspend fun register(fullName: String, email: String, password: String) =
        RetrofitInstance.api.register(RegisterRequest(fullName, email, password))
}
