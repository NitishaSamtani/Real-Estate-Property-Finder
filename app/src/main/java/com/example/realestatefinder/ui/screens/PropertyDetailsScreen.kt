package com.example.realestatefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.realestatefinder.data.model.UserSession
import com.example.realestatefinder.data.repository.FakeData

@Composable
fun PropertyDetailsScreen(propertyId: String, onBack: () -> Unit) {
    val property = FakeData.properties.find { it.id == propertyId } ?: FakeData.properties.first()
    val isFavorite = UserSession.favoriteIds.contains(property.id)
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
                },
                actions = {
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
                            tint = if (isFavorite) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (property.thumbnailUrl.isNotEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth().height(220.dp)
                ) {
                    AsyncImage(
                        model = property.thumbnailUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            } else {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.fillMaxWidth().height(220.dp)
                ) {}
            }

            Spacer(Modifier.height(16.dp))
            Text(property.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("₹${"%,.0f".format(property.price)}", fontSize = 18.sp)
            Text("📍 ${property.locality}, ${property.city}")
            Spacer(Modifier.height(8.dp))
            Text("🛏 ${property.bedrooms} Bedrooms")
            Text("🚿 ${property.bathrooms} Bathrooms")
            Text("📐 ${property.areaSqft.toInt()} sq.ft")

            Spacer(Modifier.height(16.dp))
            Text("Description", fontWeight = FontWeight.Bold)
            Text(property.description)

            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = {
                    val addressQuery = "${property.title}, ${property.locality}, ${property.city}"
                    val gmmIntentUri = android.net.Uri.parse("geo:${property.latitude},${property.longitude}?q=" + android.net.Uri.encode(addressQuery))
                    val mapIntent = android.content.Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    context.startActivity(mapIntent)
                }) { Text("View Map") }
            }

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    val dialIntent = android.content.Intent(
                        android.content.Intent.ACTION_DIAL,
                        android.net.Uri.parse("tel:${property.agent?.phone ?: "9876543210"}")
                    )
                    context.startActivity(dialIntent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("CONTACT AGENT")
            }
        }
    }
}
