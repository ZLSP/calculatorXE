package com.zlsp.calcxe.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.zlsp.calcxe.base.switch

@Composable
fun CalcXETheme(
    themeMode: ThemeMode = ThemeMode.DARK,
    colorScheme: ColorScheme = ColorScheme.GREEN,
    content: @Composable () -> Unit
) {
    val colors = colorScheme.set.getPalette(themeMode)

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