package com.zlsp.calcxe.ui.screens.settings

import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.ThemeMode

interface SettingsContract {
    sealed interface Effect

    sealed interface Event {
        class OnClickCheckBoxThemeMode(val themeMode: ThemeMode) : Event
        class OnValueChangeOneXeListener(val numOneXe: Int) : Event
        class OnClickColorScheme(val colorScheme: ColorScheme) : Event
    }

    data class State(
        val themeMode: ThemeMode,
        val colorSchemeActive: ColorScheme,
        val numOneXe: Int
    )
}