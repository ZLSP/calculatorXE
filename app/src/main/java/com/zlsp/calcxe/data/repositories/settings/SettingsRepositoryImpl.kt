package com.zlsp.calcxe.data.repositories.settings

import com.zlsp.calcxe.data.SharedPreferenceManager
import com.zlsp.calcxe.domain.UserSetupSettings

class SettingsRepositoryImpl(private val pref: SharedPreferenceManager) : SettingsRepository {
    override val userSetupSettings: UserSetupSettings = pref.getUserSetupSettings()
}