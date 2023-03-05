package com.zlsp.calcxe.ui.theme

import androidx.compose.material.Colors

data class AppPaletteSet(
    val light: Colors,
    val dark: Colors,
    val amoled: Colors
) {
    fun getPalette(themeMode: ThemeMode): Colors =
        when(themeMode) {
            ThemeMode.LIGHT -> light
            ThemeMode.DARK -> dark
            ThemeMode.AMOLED -> amoled
        }
}
