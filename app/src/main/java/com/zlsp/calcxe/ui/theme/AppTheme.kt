package com.zlsp.calcxe.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zlsp.calcxe.base.switch
import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.Shapes
import com.zlsp.calcxe.ui.theme.models.ThemeMode
import com.zlsp.calcxe.ui.theme.models.Typography

@Composable
fun AppTheme(
    themeMode: ThemeMode = ThemeMode.DARK,
    colorScheme: ColorScheme = ColorScheme.GREEN,
    systemUiController: SystemUiController = rememberSystemUiController(),
    content: @Composable () -> Unit
) {
    val themeModeState = rememberSaveable { mutableStateOf(themeMode) }
    val colorSchemeState = rememberSaveable { mutableStateOf(colorScheme) }
    val colors = colorSchemeState.value.paletteSet.getPalette(themeModeState.value)
    val systemBarsColor = colors.switch().background
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = systemBarsColor,
            darkIcons = themeModeState.value == ThemeMode.LIGHT
        )
    }
    MaterialTheme(
        colors = colors.switch(),
        typography = Typography,
        shapes = Shapes
    ) {
        CompositionLocalProvider(
            LocalThemeHandler provides ThemeHandler(themeModeState, colorSchemeState),
            content = content
        )
    }

}

@Composable
fun animateColor(targetColor: Color) =
    animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(durationMillis = 1000)
    ).value

val LocalThemeHandler = staticCompositionLocalOf<ThemeHandler> {
    error("No ThemeHandler provided")
}