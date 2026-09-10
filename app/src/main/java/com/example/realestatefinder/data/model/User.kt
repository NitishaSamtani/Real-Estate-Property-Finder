package com.example.realestatefinder.data.model

import androidx.compose.runtime.mutableStateListOf

data class User(
    val id: String,
    val fullName: String,
    val email: String,
    val role: String = "user"
)

data class AuthResponse(
    val user: User,
    val accessToken: String,
    val refreshToken: String
)

data class LoginRequest(val email: String, val password: String)

data class RegisterRequest(val fullName: String, val email: String, val password: String)

object UserSession {
    var currentUser: User? = User("1", "John Smith", "john@email.com")
    val favoriteIds = mutableStateListOf<String>("p_001") // pre-favorite the first one as a starting sample
    val registeredUsers = mutableStateListOf<User>()
}
