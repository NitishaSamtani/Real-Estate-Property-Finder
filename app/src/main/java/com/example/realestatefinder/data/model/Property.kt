package com.example.realestatefinder.data.model

data class Property(
    val id: String,
    val title: String,
    val price: Double,
    val city: String = "",
    val locality: String = "",
    val bedrooms: Int = 0,
    val bathrooms: Int = 0,
    val areaSqft: Double = 0.0,
    val thumbnailUrl: String = "",
    val images: List<String> = emptyList(),
    val description: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val isFavorite: Boolean = false,
    val agent: Agent? = null
)

data class Agent(
    val id: String,
    val name: String,
    val rating: Double = 0.0,
    val phone: String = ""
)

data class PropertyListResponse(
    val page: Int,
    val pageSize: Int,
    val total: Int,
    val items: List<Property>
)
