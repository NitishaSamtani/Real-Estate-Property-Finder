package com.example.realestatefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onNavigateToRegister: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Minimal luxury real estate property architectural background image
        AsyncImage(
            model = "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=1080&q=80",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.22f // subtle soft opacity for text readability
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = androidx.compose.ui.graphics.Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text("Welcome Back", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("Find your perfect home", fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f))
                Spacer(Modifier.height(32.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { 
                        email = it
                        errorMessage = ""
                    },
                    label = { Text("Email Address") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { 
                        password = it
                        errorMessage = ""
                    },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                if (errorMessage.isNotEmpty()) {
                    Spacer(Modifier.height(8.dp))
                    Text(errorMessage, color = MaterialTheme.colorScheme.error, fontSize = 14.sp)
                }

                Spacer(Modifier.height(8.dp))
                TextButton(onClick = { /* TODO: forgot password flow */ }) {
                    Text("Forgot Password?")
                }
                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            errorMessage = "Please enter both your email and password."
                        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            errorMessage = "Please enter a valid email address."
                        } else if (password.length < 4) {
                            errorMessage = "Password must be at least 4 characters."
                        } else {
                            val matchingUser = com.example.realestatefinder.data.model.UserSession.registeredUsers.find { user ->
                                user.email.equals(email, ignoreCase = true) 
                            }
                            
                            if (matchingUser != null) {
                                com.example.realestatefinder.data.model.UserSession.currentUser = matchingUser
                            } else {
                                val derivedName = email.substringBefore("@")
                                    .split(".", "_", "-")
                                    .joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }
                                val newUser = com.example.realestatefinder.data.model.User(
                                    id = "user_" + System.currentTimeMillis(),
                                    fullName = derivedName,
                                    email = email
                                )
                                com.example.realestatefinder.data.model.UserSession.currentUser = newUser
                            }
                            onLoginSuccess()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text("LOGIN", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.height(24.dp))
                Row {
                    Text("Don't have an account? ")
                    TextButton(onClick = onNavigateToRegister, contentPadding = PaddingValues(0.dp)) {
                        Text("Register")
                    }
                }
            }
        }
    }
}
