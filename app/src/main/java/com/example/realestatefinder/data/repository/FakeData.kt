package com.example.realestatefinder.data.repository

import com.example.realestatefinder.data.model.Agent
import com.example.realestatefinder.data.model.Property

/**
 * Sample data so the UI can be previewed/run before the backend is live.
 * Wire the ViewModels to PropertyRepository once the API is deployed.
 */
object FakeData {
    val agent = Agent(id = "a_10", name = "Raj Sharma", rating = 4.8, phone = "9876543210")

    val properties = listOf(
        Property(
            id = "p_001", title = "Luxury 3 BHK Apartment", price = 8500000.0,
            city = "Mumbai", locality = "Andheri West", bedrooms = 3, bathrooms = 2,
            areaSqft = 1450.0, description = "Modern luxury apartment with excellent connectivity and sea view balcony.",
            latitude = 19.1363, longitude = 72.8276, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=800")
        ),
        Property(
            id = "p_002", title = "Modern Apartment", price = 7200000.0,
            city = "Mumbai", locality = "Powai", bedrooms = 2, bathrooms = 2,
            areaSqft = 1100.0, description = "Bright apartment near Powai lake with full amenities.",
            latitude = 19.1176, longitude = 72.9060, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1580587771525-78b9dba3b914?w=800")
        ),
        Property(
            id = "p_003", title = "Spacious Modern Villa", price = 15000000.0,
            city = "Mumbai", locality = "Juhu", bedrooms = 4, bathrooms = 3,
            areaSqft = 2200.0, description = "Exclusive villa in Juhu beach lane with private lawn.",
            latitude = 19.1075, longitude = 72.8263, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=800")
        ),
        Property(
            id = "p_004", title = "Cozy Studio Flat", price = 4500000.0,
            city = "Mumbai", locality = "Bandra West", bedrooms = 1, bathrooms = 1,
            areaSqft = 450.0, description = "Perfect for young professionals, close to Bandstand.",
            latitude = 19.0596, longitude = 72.8295, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=800")
        ),
        Property(
            id = "p_005", title = "Penthouse with City View", price = 25000000.0,
            city = "Mumbai", locality = "Worli", bedrooms = 5, bathrooms = 4,
            areaSqft = 3500.0, description = "Ultra luxury penthouse with panoramic skyline views.",
            latitude = 19.0176, longitude = 72.8172, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?w=800")
        ),
        Property(
            id = "p_006", title = "Greenwood Mansion", price = 32000000.0,
            city = "Mumbai", locality = "Pali Hill", bedrooms = 6, bathrooms = 6,
            areaSqft = 5000.0, description = "A historical mansion set in a lush green neighborhood.",
            latitude = 19.0656, longitude = 72.8258, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1600585154526-990dcea4db0d?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1600585154526-990dcea4db0d?w=800")
        ),
        Property(
            id = "p_007", title = "Compact 2 BHK", price = 6500000.0,
            city = "Mumbai", locality = "Malad West", bedrooms = 2, bathrooms = 2,
            areaSqft = 900.0, description = "Well maintained family home in a quiet locality.",
            latitude = 19.1874, longitude = 72.8484, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1600566753190-17f0bb2a6c3e?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1600566753190-17f0bb2a6c3e?w=800")
        ),
        Property(
            id = "p_008", title = "Deluxe Residency", price = 9800000.0,
            city = "Mumbai", locality = "Chembur", bedrooms = 3, bathrooms = 3,
            areaSqft = 1600.0, description = "Premium apartment located near VESIT, Chembur.",
            latitude = 19.0461, longitude = 72.8893, agent = agent,
            thumbnailUrl = "https://images.unsplash.com/photo-1512917774080-9991f1c4c750?w=600&q=80",
            images = listOf("https://images.unsplash.com/photo-1512917774080-9991f1c4c750?w=800")
        )
    )
}
