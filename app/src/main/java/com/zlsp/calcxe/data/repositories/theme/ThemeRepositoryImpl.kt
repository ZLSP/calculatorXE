package com.zlsp.calcxe.data.repositories.theme

import com.zlsp.calcxe.data.UserStorage
import com.zlsp.calcxe.domain.UserSettings

class ThemeRepositoryImpl(private val userStorage: UserStorage): ThemeRepository {
    override val userSettings: UserSettings
        get() = userStorage.getUserSetupSettings()
}