package com.zlsp.calcxe.ui.screens.settings

import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

interface SettingsContract {
    sealed interface Effect {
        object UpdateConfiguration : Effect
    }

    sealed interface Event {
        class OnClickCheckBoxDarkTheme(val isCheck: Boolean) : Event
        class OnClickCheckBoxAmoledTheme(val isCheck: Boolean) : Event
        class OnValueChangeOneXeListener(val numOneXe: Int) : Event
        class OnClickColorScheme(val colorScheme: ColorScheme) : Event
    }

    data class State(
        val themeMode: ThemeMode,
        val colorSchemeActive: ColorScheme,
        val numOneXe: Int
    )
}