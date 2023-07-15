package com.zlsp.calcxe.ui.theme.models

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object AppPallet {

    private val greenLightColorPalette = lightColors(
        primary = AppColor.greenLightPrimary,
        onPrimary = AppColor.greenLightOnPrimary,
        surface = AppColor.greenLightPlaceholder,
        background = AppColor.greenLightBackground,
        onBackground = AppColor.greenLightPrimary

    )

    private val greenDarkColorPalette = darkColors(
        primary = AppColor.greenDarkPrimary,
        onPrimary = AppColor.greenDarkOnPrimary,
        surface = AppColor.greenDarkPlaceholder,
        background = AppColor.greenDarkBackground,
        onBackground = AppColor.greenDarkPrimary
    )
    
    private val greenAmoledColorPalette = greenDarkColorPalette.copy(background = Color.Black)

    val greenSet = AppPaletteSet(
        light = greenLightColorPalette,
        dark = greenDarkColorPalette,
        amoled = greenAmoledColorPalette
    )

    private val pinkLightColorPalette = lightColors(
        primary = AppColor.pinkLightPrimary,
        onPrimary = AppColor.pinkLightOnPrimary,
        surface = AppColor.pinkLightPlaceholder,
        background = AppColor.pinkLightBackground,
        onBackground = AppColor.pinkLightPrimary
    )

    private val pinkDarkColorPalette = darkColors(
        primary = AppColor.pinkDarkPrimary,
        onPrimary = AppColor.pinkDarkOnPrimary,
        surface = AppColor.pinkDarkPlaceholder,
        background = AppColor.pinkDarkBackground,
        onBackground = AppColor.pinkDarkPrimary
    )

    private val pinkAmoledColorPalette = pinkDarkColorPalette.copy(background = Color.Black)

    val pinkSet = AppPaletteSet(
        light = pinkLightColorPalette,
        dark = pinkDarkColorPalette,
        amoled = pinkAmoledColorPalette
    )

    private val purpleLightColorPalette = lightColors(
        primary = AppColor.purpleLightPrimary,
        onPrimary = AppColor.purpleLightOnPrimary,
        surface = AppColor.purpleLightPlaceholder,
        background = AppColor.purpleLightBackground,
        onBackground = AppColor.purpleLightPrimary
    )

    private val purpleDarkColorPalette = darkColors(
        primary = AppColor.purpleDarkPrimary,
        onPrimary = AppColor.purpleDarkOnPrimary,
        surface = AppColor.purpleDarkPlaceholder,
        background = AppColor.purpleDarkBackground,
        onBackground = AppColor.purpleDarkPrimary
    )


    private val purpleAmoledColorPalette = purpleDarkColorPalette.copy(background = Color.Black)

    val purpleSet = AppPaletteSet(
        light = purpleLightColorPalette,
        dark = purpleDarkColorPalette,
        amoled = purpleAmoledColorPalette
    )

    private val deepPurpleLightColorPalette = lightColors(
        primary = AppColor.deepPurpleLightPrimary,
        onPrimary = AppColor.deepPurpleLightOnPrimary,
        surface = AppColor.deepPurpleLightPlaceholder,
        background = AppColor.deepPurpleLightBackground,
        onBackground = AppColor.deepPurpleLightPrimary
    )

    private val deepPurpleDarkColorPalette = darkColors(
        primary = AppColor.deepPurpleDarkPrimary,
        onPrimary = AppColor.deepPurpleDarkOnPrimary,
        surface = AppColor.deepPurpleDarkPlaceholder,
        background = AppColor.deepPurpleDarkBackground,
        onBackground = AppColor.deepPurpleDarkPrimary
    )

    private val deepPurpleAmoledColorPalette = deepPurpleDarkColorPalette.copy(background = Color.Black)

    val deepPurpleSet = AppPaletteSet(
        light = deepPurpleLightColorPalette,
        dark = deepPurpleDarkColorPalette,
        amoled = deepPurpleAmoledColorPalette
    )

    private val indigoLightColorPalette = lightColors(
        primary = AppColor.indigoLightPrimary,
        onPrimary = AppColor.indigoLightOnPrimary,
        surface = AppColor.indigoLightPlaceholder,
        background = AppColor.indigoLightBackground,
        onBackground = AppColor.indigoLightPrimary
    )

    private val indigoDarkColorPalette = darkColors(
        primary = AppColor.indigoDarkPrimary,
        onPrimary = AppColor.indigoDarkOnPrimary,
        surface = AppColor.indigoDarkPlaceholder,
        background = AppColor.indigoDarkBackground,
        onBackground = AppColor.indigoDarkPrimary
    )

    private val indigoAmoledColorPalette = indigoDarkColorPalette.copy(background = Color.Black)

    val indigoSet = AppPaletteSet(
        light = indigoLightColorPalette,
        dark = indigoDarkColorPalette,
        amoled = indigoAmoledColorPalette
    )

    private val blueLightColorPalette = lightColors(
        primary = AppColor.blueLightPrimary,
        onPrimary = AppColor.blueLightOnPrimary,
        surface = AppColor.blueLightPlaceholder,
        background = AppColor.blueLightBackground,
        onBackground = AppColor.blueLightPrimary
    )

    private val blueDarkColorPalette = darkColors(
        primary = AppColor.blueDarkPrimary,
        onPrimary = AppColor.blueDarkOnPrimary,
        surface = AppColor.blueDarkPlaceholder,
        background = AppColor.blueDarkBackground,
        onBackground = AppColor.blueDarkPrimary
    )

    private val blueAmoledColorPalette = blueDarkColorPalette.copy(background = Color.Black)

    val blueSet = AppPaletteSet(
        light = blueLightColorPalette,
        dark = blueDarkColorPalette,
        amoled = blueAmoledColorPalette
    )

    private val cyanLightColorPalette = lightColors(
        primary = AppColor.cyanLightPrimary,
        onPrimary = AppColor.cyanLightOnPrimary,
        surface = AppColor.cyanLightPlaceholder,
        background = AppColor.cyanLightBackground,
        onBackground = AppColor.cyanLightPrimary
    )

    private val cyanDarkColorPalette = darkColors(
        primary = AppColor.cyanDarkPrimary,
        onPrimary = AppColor.cyanDarkOnPrimary,
        surface = AppColor.cyanDarkPlaceholder,
        background = AppColor.cyanDarkBackground,
        onBackground = AppColor.cyanDarkPrimary
    )

    private val cyanAmoledColorPalette = cyanDarkColorPalette.copy(background = Color.Black)

    val cyanSet = AppPaletteSet(
        light = cyanLightColorPalette,
        dark = cyanDarkColorPalette,
        amoled = cyanAmoledColorPalette
    )

    private val orangeLightColorPalette = lightColors(
        primary = AppColor.orangeLightPrimary,
        onPrimary = AppColor.orangeLightOnPrimary,
        surface = AppColor.orangeLightPlaceholder,
        background = AppColor.orangeLightBackground,
        onBackground = AppColor.orangeLightPrimary
    )

    private val orangeDarkColorPalette = darkColors(
        primary = AppColor.orangeDarkPrimary,
        onPrimary = AppColor.orangeDarkOnPrimary,
        surface = AppColor.orangeDarkPlaceholder,
        background = AppColor.orangeDarkBackground,
        onBackground = AppColor.orangeDarkPrimary
    )

    private val orangeAmoledColorPalette = orangeDarkColorPalette.copy(background = Color.Black)

    val orangeSet = AppPaletteSet(
        light = orangeLightColorPalette,
        dark = orangeDarkColorPalette,
        amoled = orangeAmoledColorPalette
    )

}