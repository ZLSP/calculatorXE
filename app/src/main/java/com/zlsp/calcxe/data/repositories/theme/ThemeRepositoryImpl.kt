package com.zlsp.calcxe.data.repositories.theme

import com.zlsp.calcxe.data.UserStorage
import com.zlsp.calcxe.domain.UserSettings

class ThemeRepositoryImpl(userStorage: UserStorage): ThemeRepository {
    override val userSettings: UserSettings = userStorage.getUserSetupSettings()
}