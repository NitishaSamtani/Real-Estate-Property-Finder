package com.example.realestatefinder.data.remote

import com.example.realestatefinder.data.model.*
import retrofit2.http.*

interface ApiService {

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse

    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @GET("api/properties")
    suspend fun getProperties(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ): PropertyListResponse

    @GET("api/properties/search")
    suspend fun searchProperties(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): PropertyListResponse

    @GET("api/properties/filter")
    suspend fun filterProperties(
        @Query("city") city: String? = null,
        @Query("type") type: String? = null,
        @Query("minPrice") minPrice: Double? = null,
        @Query("maxPrice") maxPrice: Double? = null,
        @Query("bedrooms") bedrooms: Int? = null
    ): PropertyListResponse

    @GET("api/properties/nearby")
    suspend fun getNearbyProperties(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("radiusKm") radiusKm: Double = 5.0
    ): PropertyListResponse

    @GET("api/properties/{id}")
    suspend fun getPropertyDetails(@Path("id") id: String): Property

    @GET("api/favorites")
    suspend fun getFavorites(): PropertyListResponse

    @POST("api/favorites/{propertyId}")
    suspend fun addFavorite(@Path("propertyId") propertyId: String)

    @DELETE("api/favorites/{propertyId}")
    suspend fun removeFavorite(@Path("propertyId") propertyId: String)

    @POST("api/inquiries")
    suspend fun sendInquiry(@Body request: Map<String, String>)

    @GET("api/users/me")
    suspend fun getProfile(): User
}
