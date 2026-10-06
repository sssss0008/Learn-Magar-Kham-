package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = MagarDarkPrimary,
    onPrimary = Color(0xFF49000F),
    primaryContainer = MagarCrimsonDark,
    onPrimaryContainer = Color(0xFFFFD9DD),
    secondary = MagarDarkSecondary,
    onSecondary = Color(0xFF452B00),
    secondaryContainer = Color(0xFF633F00),
    onSecondaryContainer = MagarGoldContainer,
    tertiary = MagarDarkTertiary,
    onTertiary = Color(0xFF00391A),
    background = MagarDarkBackground,
    onBackground = MagarDarkOnSurface,
    surface = MagarDarkSurface,
    onSurface = MagarDarkOnSurface,
    surfaceVariant = MagarDarkSurfaceVariant,
    onSurfaceVariant = MagarDarkOnSurfaceVariant,
    outline = Color(0xFF9E8D8A)
)

private val LightColorScheme = lightColorScheme(
    primary = MagarCrimsonPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFD9DE),
    onPrimaryContainer = MagarCrimsonDark,
    secondary = MagarGoldSecondary,
    onSecondary = Color.White,
    secondaryContainer = MagarGoldContainer,
    onSecondaryContainer = Color(0xFF4D2700),
    tertiary = MagarForestTertiary,
    onTertiary = Color.White,
    tertiaryContainer = MagarForestContainer,
    onTertiaryContainer = Color(0xFF00210E),
    background = MagarCreamBackground,
    onBackground = MagarOnSurface,
    surface = MagarCreamSurface,
    onSurface = MagarOnSurface,
    surfaceVariant = MagarSurfaceVariant,
    onSurfaceVariant = MagarOnSurfaceVariant,
    outline = MagarOutline
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

