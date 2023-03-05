package com.zlsp.calcxe.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zlsp.calcxe.base.switch

@Composable
fun AppTheme(
    themeMode: ThemeMode = ThemeMode.DARK,
    colorScheme: ColorScheme = ColorScheme.GREEN,
    systemUiController: SystemUiController = rememberSystemUiController(),
    content: @Composable () -> Unit
) {
    val colors = colorScheme.set.getPalette(themeMode)
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = colors.background,
            darkIcons = themeMode == ThemeMode.LIGHT
        )
    }
    MaterialTheme(
        colors = colors.switch(),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun animateColor(targetColor: Color) =
    animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(durationMillis = 1000)
    ).value