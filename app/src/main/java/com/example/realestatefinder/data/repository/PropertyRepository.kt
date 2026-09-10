package com.example.realestatefinder.data.repository

import com.example.realestatefinder.data.model.*
import com.example.realestatefinder.data.remote.RetrofitInstance

/**
 * Thin wrapper around ApiService so ViewModels don't talk to Retrofit directly.
 * Swap the RetrofitInstance.api calls for fake/in-memory data while the backend
 * isn't deployed yet (see FakeData.kt for sample content used by the previews).
 */
class PropertyRepository {

    suspend fun getHomeFeed(page: Int = 1) =
        RetrofitInstance.api.getProperties(page = page)

    suspend fun search(query: String) =
        RetrofitInstance.api.searchProperties(query)

    suspend fun filter(
        city: String? = null,
        type: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null,
        bedrooms: Int? = null
    ) = RetrofitInstance.api.filterProperties(city, type, minPrice, maxPrice, bedrooms)

    suspend fun nearby(lat: Double, lng: Double, radiusKm: Double = 5.0) =
        RetrofitInstance.api.getNearbyProperties(lat, lng, radiusKm)

    suspend fun details(id: String) =
        RetrofitInstance.api.getPropertyDetails(id)

    suspend fun favorites() =
        RetrofitInstance.api.getFavorites()

    suspend fun addFavorite(propertyId: String) =
        RetrofitInstance.api.addFavorite(propertyId)

    suspend fun removeFavorite(propertyId: String) =
        RetrofitInstance.api.removeFavorite(propertyId)
}
