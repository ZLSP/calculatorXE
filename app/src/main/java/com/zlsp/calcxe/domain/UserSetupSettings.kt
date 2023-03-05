package com.zlsp.calcxe.domain

import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

data class UserSetupSettings(
    val defaultXE: Int,
    val themeMode: ThemeMode,
    val colorScheme: ColorScheme
)