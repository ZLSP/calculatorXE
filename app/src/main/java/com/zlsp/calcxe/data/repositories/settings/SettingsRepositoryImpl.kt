package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.data.UserStorage
import com.zlsp.calcxe.domain.UserSettings

class SettingsRepositoryImpl(
    private val pref: UserStorage
) : SettingsRepository {
    override val userSettings: UserSettings = pref.getUserSetupSettings()
    override fun updateSettings(userSettings: UserSettings) {
        pref.updateSettings(userSettings)
    }
}