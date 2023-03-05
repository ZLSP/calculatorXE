package com.zlsp.calcxe.data

import android.content.Context
import com.zlsp.calcxe.base.Constants
import com.zlsp.calcxe.domain.UserSetupSettings
import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

class SharedPreferenceManager(context: Context) {

    companion object {
        const val SETTINGS_PREFERENCES = "SettingsPreferences"
        const val KEY_THEME_MODE = "themeMode"
        const val KEY_COLOR_SCHEME = "colorScheme"
        const val KEY_DEFAULT_XE = "defaultXe"
        const val KEY_FULL_AD = "full_ad"
        const val DEFAULT_XE = 10
    }

    private val pref = context.getSharedPreferences(SETTINGS_PREFERENCES, Context.MODE_PRIVATE)

    private val colorScheme: ColorScheme
        get() = getColorScheme(pref.getInt(KEY_COLOR_SCHEME, 0))

    private val themeMode: ThemeMode
        get() = getThemeMode(pref.getInt(KEY_THEME_MODE, 0))

    private val defaultXE : Int
        get() = pref.getInt(KEY_DEFAULT_XE, DEFAULT_XE)

    fun getUserSetupSettings(): UserSetupSettings {
        return UserSetupSettings(
            defaultXE = defaultXE,
            themeMode = themeMode,
            colorScheme = colorScheme
        )
    }

    fun updateSettings(userSetupSettings: UserSetupSettings) {
        setDataPref(KEY_DEFAULT_XE, userSetupSettings.defaultXE)
        setDataPref(KEY_COLOR_SCHEME, userSetupSettings.colorScheme.id)
        setDataPref(KEY_THEME_MODE, userSetupSettings.themeMode.id)
    }

    fun isShowAd(): Boolean {
        val numAd: Int = pref.getInt(KEY_FULL_AD, 1)
        println("yandex isShowAd $numAd")
        return if (numAd > 4) {
            setDataPref(KEY_FULL_AD, 1)
            true
        } else {
            setDataPref(KEY_FULL_AD, numAd+1)
            false
        }
    }

    private fun getThemeMode(id: Int) = when (id) {
        Constants.THEME_MODE_DARK -> ThemeMode.DARK
        Constants.THEME_MODE_AMOLED -> ThemeMode.AMOLED
        else -> ThemeMode.LIGHT
    }

    private fun getColorScheme(id: Int) = when (id) {
        Constants.COLOR_SCHEME_PINK -> ColorScheme.PINK
        Constants.COLOR_SCHEME_PURPLE -> ColorScheme.PURPLE
        Constants.COLOR_SCHEME_DEEP_PURPLE -> ColorScheme.DEEP_PURPLE
        Constants.COLOR_SCHEME_INDIGO -> ColorScheme.INDIGO
        Constants.COLOR_SCHEME_BLUE -> ColorScheme.BLUE
        Constants.COLOR_SCHEME_CYAN -> ColorScheme.CYAN
        Constants.COLOR_SCHEME_ORANGE -> ColorScheme.ORANGE
        else -> ColorScheme.GREEN
    }

    private fun setDataPref(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }
}