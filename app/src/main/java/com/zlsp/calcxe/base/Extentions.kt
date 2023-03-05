package com.zlsp.calcxe.base

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import com.zlsp.calcxe.ui.theme.animateColor

@Composable
fun Colors.switch() = this.copy(
    primary = animateColor(targetColor = this.primary),
    onPrimary = animateColor(targetColor = this.onPrimary),
    background = animateColor(targetColor = this.background),
    surface = animateColor(targetColor = this.surface)
)

fun Any.printHashCode() {
    println(this.hashCode())
}