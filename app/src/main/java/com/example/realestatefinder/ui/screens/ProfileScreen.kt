package com.example.realestatefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realestatefinder.data.model.UserSession

@Composable
fun ProfileScreen(onBack: () -> Unit, onLogout: () -> Unit) {
    val user = UserSession.currentUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(64.dp))
            Spacer(Modifier.height(8.dp))
            Text(user?.fullName ?: "Guest", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(user?.email ?: "No email available")
            Spacer(Modifier.height(48.dp))

            Button(
                onClick = {
                    UserSession.currentUser = null
                    onLogout()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("LOGOUT", color = MaterialTheme.colorScheme.onError)
            }
        }
    }
}
