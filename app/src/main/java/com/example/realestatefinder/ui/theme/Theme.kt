package com.example.realestatefinder.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val PrimaryBlue = Color(0xFF1E5AA8)
val AccentOrange = Color(0xFFFF6B35)
val BackgroundLight = Color(0xFFF5F7FA)

// Additional theme color definitions
val PrimaryGreen = Color(0xFF2E7D32)
val AccentGold = Color(0xFFF57C00)

val PrimaryPurple = Color(0xFF6A1B9A)
val AccentTeal = Color(0xFF00897B)

enum class AppThemeMode {
    LIGHT_BLUE, DARK_BLUE, LIGHT_GREEN, LIGHT_PURPLE
}

object ThemeController {
    var currentTheme by mutableStateOf(AppThemeMode.LIGHT_BLUE)
}

private val LightBlueColors = lightColorScheme(
    primary = PrimaryBlue,
    secondary = AccentOrange,
    background = BackgroundLight,
    surface = Color.White
)

private val DarkBlueColors = darkColorScheme(
    primary = Color(0xFF42A5F5),
    secondary = Color(0xFFFFB74D),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E)
)

private val LightGreenColors = lightColorScheme(
    primary = PrimaryGreen,
    secondary = AccentGold,
    background = Color(0xFFF1F8E9),
    surface = Color.White
)

private val LightPurpleColors = lightColorScheme(
    primary = PrimaryPurple,
    secondary = AccentTeal,
    background = Color(0xFFF3E5F5),
    surface = Color.White
)

@Composable
fun RealEstateFinderTheme(
    content: @Composable () -> Unit
) {
    val colors = when (ThemeController.currentTheme) {
        AppThemeMode.LIGHT_BLUE -> LightBlueColors
        AppThemeMode.DARK_BLUE -> DarkBlueColors
        AppThemeMode.LIGHT_GREEN -> LightGreenColors
        AppThemeMode.LIGHT_PURPLE -> LightPurpleColors
    }
    
    MaterialTheme(colorScheme = colors, content = content)
}
