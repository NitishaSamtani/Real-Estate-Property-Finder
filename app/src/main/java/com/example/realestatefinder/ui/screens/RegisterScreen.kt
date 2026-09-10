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
fun RegisterScreen(onRegisterSuccess: () -> Unit, onNavigateToLogin: () -> Unit) {
    var fullName by remember { mutableStateOf("") }
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
                Text("Create Account", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("Sign up to explore properties", fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f))
                Spacer(Modifier.height(32.dp))

                OutlinedTextField(
                    value = fullName, 
                    onValueChange = { 
                        fullName = it
                        errorMessage = ""
                    },
                    label = { Text("Full Name") }, 
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(Modifier.height(16.dp))
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

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (fullName.isBlank() || email.isBlank() || password.isBlank()) {
                            errorMessage = "All fields are required."
                        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            errorMessage = "Please enter a valid email address."
                        } else if (password.length < 4) {
                            errorMessage = "Password must be at least 4 characters."
                        } else {
                            val newUser = com.example.realestatefinder.data.model.User(
                                id = "user_" + System.currentTimeMillis(),
                                fullName = fullName,
                                email = email
                            )
                            com.example.realestatefinder.data.model.UserSession.registeredUsers.add(newUser)
                            com.example.realestatefinder.data.model.UserSession.currentUser = newUser
                            onRegisterSuccess()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text("REGISTER", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.height(24.dp))
                Row {
                    Text("Already have an account? ")
                    TextButton(onClick = onNavigateToLogin, contentPadding = PaddingValues(0.dp)) {
                        Text("Login")
                    }
                }
            }
        }
    }
}
