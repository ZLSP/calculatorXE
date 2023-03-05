package com.zlsp.calcxe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with

val Typography = Typography(
    //settingsTitle
    h1 = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
    ),
    //settingsItem
    h2 = TextStyle(
        fontSize = 30.sp,
    ),
    //popupTitle
    h3 = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    ),
    //textFieldValue/placeholder
    h4 = TextStyle(
        textAlign = TextAlign.Center,
        fontSize = 18.sp
    ),
    //itemStickyHeader
    h5 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    //titleCategory
    h6 = TextStyle(
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    ),
    //listBody
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 11.sp,
    ),
    //popupBody
    body2 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )
)