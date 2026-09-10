package com.example.realestatefinder.ui.navigation

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val FAVORITES = "favorites"
    const val PROFILE = "profile"
    const val PROPERTY_DETAILS = "property/{propertyId}"

    fun propertyDetails(propertyId: String) = "property/$propertyId"
}
