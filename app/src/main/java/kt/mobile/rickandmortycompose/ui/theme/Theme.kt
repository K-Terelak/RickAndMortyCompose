package kt.mobile.rickandmortycompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryDark,
    onPrimary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = Color.White,
    surface = Color.Black,
    background = Color.Black,
    onBackground = primaryDark,

)

private val LightColorPalette = lightColors(
    primary = Color.White,
    onPrimary = Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    onSurface = Color.White,
    surface = surfaceLight,
    background = surfaceLight,
    onBackground = Color.White,


)

@Composable
fun RickAndMortyComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}