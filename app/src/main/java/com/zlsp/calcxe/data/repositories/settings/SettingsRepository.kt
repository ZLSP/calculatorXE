package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.domain.UserSettings

interface SettingsRepository {
    val userSettings : UserSettings
    fun updateSettings(userSettings: UserSettings)
}