package com.example.realestatefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.realestatefinder.data.model.Property
import com.example.realestatefinder.data.model.UserSession
import com.example.realestatefinder.data.repository.FakeData
import com.example.realestatefinder.ui.theme.AppThemeMode
import com.example.realestatefinder.ui.theme.ThemeController

@Composable
fun HomeScreen(
    onPropertyClick: (String) -> Unit,
    onNavigateToFavorites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var showThemeMenu by remember { mutableStateOf(false) }
    
    val properties = remember(searchText) {
        if (searchText.isBlank()) {
            FakeData.properties
        } else {
            FakeData.properties.filter {
                it.title.contains(searchText, ignoreCase = true) ||
                        it.locality.contains(searchText, ignoreCase = true) ||
                        it.city.contains(searchText, ignoreCase = true)
            }
        }
    }
    val userName = UserSession.currentUser?.fullName ?: "User"

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") })
                NavigationBarItem(selected = false, onClick = onNavigateToFavorites, icon = { Icon(Icons.Default.FavoriteBorder, null) }, label = { Text("Saved") })
                NavigationBarItem(selected = false, onClick = onNavigateToProfile, icon = { Icon(Icons.Default.Person, null) }, label = { Text("Me") })
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Hi, $userName 👋", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Text("Find your dream property", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                }
                
                Box {
                    IconButton(onClick = { showThemeMenu = true }) {
                        Icon(Icons.Default.Palette, contentDescription = "Change Theme", tint = MaterialTheme.colorScheme.primary)
                    }
                    DropdownMenu(
                        expanded = showThemeMenu,
                        onDismissRequest = { showThemeMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Light Blue") },
                            onClick = { 
                                ThemeController.currentTheme = AppThemeMode.LIGHT_BLUE
                                showThemeMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Dark Mode") },
                            onClick = { 
                                ThemeController.currentTheme = AppThemeMode.DARK_BLUE
                                showThemeMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Light Green") },
                            onClick = { 
                                ThemeController.currentTheme = AppThemeMode.LIGHT_GREEN
                                showThemeMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Light Purple") },
                            onClick = { 
                                ThemeController.currentTheme = AppThemeMode.LIGHT_PURPLE
                                showThemeMenu = false
                            }
                        )
                    }
                }
            }
            
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Search location...") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(16.dp))

            Text("Featured Properties", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(properties) { property ->
                    PropertyCard(property = property, onClick = { onPropertyClick(property.id) })
                }
            }
        }
    }
}

@Composable
fun PropertyCard(property: Property, onClick: () -> Unit) {
    val isFavorite = UserSession.favoriteIds.contains(property.id)

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                if (property.thumbnailUrl.isNotEmpty()) {
                    AsyncImage(
                        model = property.thumbnailUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Surface(color = MaterialTheme.colorScheme.surfaceVariant, modifier = Modifier.fillMaxSize()) {}
                }
                IconButton(onClick = {
                    if (isFavorite) {
                        UserSession.favoriteIds.remove(property.id)
                    } else {
                        UserSession.favoriteIds.add(property.id)
                    }
                }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Save",
                        tint = if (isFavorite) MaterialTheme.colorScheme.secondary else androidx.compose.ui.graphics.Color.White
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(property.title, fontWeight = FontWeight.Bold)
            Text("₹${"%,.0f".format(property.price)}")
            Text("📍 ${property.locality}, ${property.city}")
            Text("🛏 ${property.bedrooms}   🚿 ${property.bathrooms}   📐 ${property.areaSqft.toInt()} ft²")
        }
    }
}
