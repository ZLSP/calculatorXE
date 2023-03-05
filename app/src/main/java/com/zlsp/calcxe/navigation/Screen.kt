package com.zlsp.calcxe.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.zlsp.calcxe.R

enum class Screen(val route: String, @StringRes val labelId: Int, @DrawableRes val iconId: Int) {
    SETTINGS("settings", R.string.bottomBarSettings, R.drawable.ic_bottom_nav_settings),
    HOME("home", R.string.bottomBarHome, R.drawable.ic_bottom_nav_home),
    LIST("list", R.string.bottomBarList, R.drawable.ic_bottom_nav_list)
}