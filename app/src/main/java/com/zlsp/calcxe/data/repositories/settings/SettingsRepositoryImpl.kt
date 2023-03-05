package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.data.UserStorage
import com.zlsp.calcxe.domain.UserSettings
import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

class SettingsRepositoryImpl(private val pref: UserStorage) : SettingsRepository {

    override val userSettings: UserSettings = pref.getUserSetupSettings()

    override fun updateThemeMode(themeMode: ThemeMode) = pref.updateThemeMode(themeMode)

    override fun updateColorScheme(colorScheme: ColorScheme) = pref.updateColorScheme(colorScheme)

    override fun updateNumOneXe(numOneXe: Int) = pref.updateNumOneXe(numOneXe)
}