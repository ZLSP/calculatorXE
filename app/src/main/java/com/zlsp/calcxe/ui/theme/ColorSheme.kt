package com.zlsp.calcxe.ui.theme

import com.zlsp.calcxe.base.Constants

enum class ColorScheme(val id: Int, val set: AppPaletteSet) {
    GREEN(Constants.COLOR_SCHEME_GREEN, AppPallet.greenSet),
    PINK(Constants.COLOR_SCHEME_PINK, AppPallet.pinkSet),
    PURPLE(Constants.COLOR_SCHEME_PURPLE, AppPallet.purpleSet),
    DEEP_PURPLE(Constants.COLOR_SCHEME_DEEP_PURPLE, AppPallet.deepPurpleSet),
    INDIGO(Constants.COLOR_SCHEME_INDIGO, AppPallet.indigoSet),
    BLUE(Constants.COLOR_SCHEME_BLUE, AppPallet.blueSet),
    CYAN(Constants.COLOR_SCHEME_CYAN, AppPallet.cyanSet),
    ORANGE(Constants.COLOR_SCHEME_ORANGE, AppPallet.orangeSet)
}