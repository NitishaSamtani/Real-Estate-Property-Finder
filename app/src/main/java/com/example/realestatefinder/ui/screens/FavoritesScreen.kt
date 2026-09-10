package com.example.realestatefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.realestatefinder.data.model.UserSession
import com.example.realestatefinder.data.repository.FakeData

@Composable
fun FavoritesScreen(onBack: () -> Unit, onPropertyClick: (String) -> Unit) {
    val favorites = FakeData.properties.filter { UserSession.favoriteIds.contains(it.id) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Saved Properties") },
                navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) } }
            )
        }
    ) { padding ->
        if (favorites.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No saved properties yet.")
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(padding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(favorites) { property ->
                    PropertyCard(property = property, onClick = { onPropertyClick(property.id) })
                }
            }
        }
    }
}
