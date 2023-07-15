package com.zlsp.calcxe.ui.theme

import androidx.compose.runtime.MutableState
import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.ThemeMode

class ThemeHandler(
    private val themeModeState: MutableState<ThemeMode>,
    private val colorSchemeState: MutableState<ColorScheme>
) {
    fun setThemeMode(mode: ThemeMode) {
        themeModeState.value = mode
    }

    fun setColorScheme(colorScheme: ColorScheme) {
        colorSchemeState.value = colorScheme
    }
}