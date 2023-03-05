package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.domain.UserSettings
import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

interface SettingsRepository {
    val userSettings : UserSettings
    fun updateThemeMode(themeMode: ThemeMode)
    fun updateColorScheme(colorScheme: ColorScheme)
    fun updateNumOneXe(numOneXe: Int)
}