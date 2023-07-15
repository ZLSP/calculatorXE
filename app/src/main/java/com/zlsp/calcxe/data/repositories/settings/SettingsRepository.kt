package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.domain.UserSettings
import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.ThemeMode

interface SettingsRepository {
    val userSettings : UserSettings
    fun updateThemeMode(themeMode: ThemeMode)
    fun updateColorScheme(colorScheme: ColorScheme)
    fun updateNumOneXe(numOneXe: Int)
}