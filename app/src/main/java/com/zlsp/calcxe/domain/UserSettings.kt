package com.zlsp.calcxe.domain

import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.ThemeMode

data class UserSettings(
    val numOneXe: Int,
    val themeMode: ThemeMode,
    val colorScheme: ColorScheme
)