package com.zlsp.calcxe.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zlsp.calcxe.R
import com.zlsp.calcxe.base.Constants
import com.zlsp.calcxe.base.printHashCode
import com.zlsp.calcxe.base.switch
import com.zlsp.calcxe.ui.theme.AppTheme
import com.zlsp.calcxe.ui.theme.LocalThemeHandler
import com.zlsp.calcxe.ui.theme.models.ColorScheme
import com.zlsp.calcxe.ui.theme.models.ThemeMode

private const val PADDING_VIEW = 10

@Composable
fun SettingsScreen(
    state: SettingsContract.State,
    sendEvent: (SettingsContract.Event) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(Constants.PADDING_SCREEN.dp)
    ) {
//        ViewTitle(R.string.settingsTitle)
//        Spacer(Modifier.height(PADDING_VIEW.dp))
        ViewSettingsItemNumXe(
            value = state.numOneXe,
            onClickItem = { sendEvent(SettingsContract.Event.OnValueChangeOneXeListener(it)) }
        )
        Spacer(Modifier.height(PADDING_VIEW.dp))
        ViewSettingsItemCheckbox(
            nameId = R.string.settingsDarkMode,
            isCheck = state.themeMode == ThemeMode.DARK || state.themeMode == ThemeMode.AMOLED,
            themeMode = ThemeMode.DARK,
            onClick = { sendEvent(SettingsContract.Event.OnClickCheckBoxThemeMode(it)) }
        )
        Spacer(Modifier.height(PADDING_VIEW.dp))
        ViewSettingsItemCheckbox(
            nameId = R.string.settingsAmoledMode,
            isCheck = state.themeMode == ThemeMode.AMOLED,
            themeMode = ThemeMode.AMOLED,
            onClick = { sendEvent(SettingsContract.Event.OnClickCheckBoxThemeMode(it)) }
        )
        Spacer(Modifier.height(PADDING_VIEW.dp))
        ViewTitle(R.string.settingsTitleColorScheme)
        Spacer(Modifier.height(Constants.PADDING_SCREEN.dp))
        ViewColorSchemes(
            themeMode = state.themeMode,
            colorSchemeActive = state.colorSchemeActive,
            onClickItem = { sendEvent(SettingsContract.Event.OnClickColorScheme(it)) }
        )
    }
}

@Composable
private fun ViewColorSchemes(
    themeMode: ThemeMode,
    colorSchemeActive: ColorScheme,
    onClickItem: (ColorScheme) -> Unit
) {
    val listSchemes by remember {
        mutableStateOf(
            listOf(
                ColorScheme.GREEN,
                ColorScheme.PINK,
                ColorScheme.PURPLE,
                ColorScheme.DEEP_PURPLE,
                ColorScheme.INDIGO,
                ColorScheme.BLUE,
                ColorScheme.CYAN,
                ColorScheme.ORANGE,
            )
        )
    }
    val themeHandler = LocalThemeHandler.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(
                items = listSchemes,
                key = { it.id }
            ) {
                ColorBox(
                    colorScheme = it,
                    themeMode = themeMode,
                    isActive = it == colorSchemeActive
                ) {
                    themeHandler.setColorScheme(it)
                    onClickItem(it)
                }
            }
        }
    )
}

@Composable
private fun ColorBox(
    colorScheme: ColorScheme,
    themeMode: ThemeMode,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Box {
        Button(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorScheme.paletteSet.getPalette(themeMode).switch().primary
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = onClick
        ) {
            AnimatedVisibility(
                visible = isActive
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_check),
                    contentDescription = "",
                    tint = colorScheme.paletteSet.getPalette(themeMode).switch().onPrimary
                )
            }
        }
    }

}

@Composable
private fun ViewSettingsItemCheckbox(
    @StringRes nameId: Int,
    isCheck: Boolean,
    themeMode: ThemeMode,
    onClick: (ThemeMode) -> Unit
) {
    val themeHandler = LocalThemeHandler.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(nameId),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary
        )
        Checkbox(
            modifier = Modifier.weight(1f),
            checked = isCheck,
            onCheckedChange = {
                val newThemeMode = when (themeMode) {
                    ThemeMode.DARK -> {
                        if (it) ThemeMode.DARK else ThemeMode.LIGHT
                    }

                    ThemeMode.AMOLED -> {
                        if (it) ThemeMode.AMOLED else ThemeMode.DARK
                    }

                    else -> ThemeMode.LIGHT
                }
                onClick(newThemeMode)
                themeHandler.setThemeMode(newThemeMode)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colors.primary,
                checkmarkColor = MaterialTheme.colors.onPrimary,
                uncheckedColor = MaterialTheme.colors.primary
            )
        )
    }
}

@Composable
private fun ViewSettingsItemNumXe(value: Int, onClickItem: (Int) -> Unit) {
    onClickItem.printHashCode()
    value.printHashCode()
    val listVariant by remember {
        mutableStateOf(8..15)
    }
    var isVisibleDropdownMenu by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.settingsXE),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary
        )
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(
                onClick = { isVisibleDropdownMenu = true }
            ) {
                Text(
                    text = value.toString(),
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary
                )
            }

            Box(Modifier.width(80.dp)) {
                DropdownMenu(
                    modifier = Modifier
                        .width(80.dp)
                        .background(MaterialTheme.colors.background),
                    expanded = isVisibleDropdownMenu,
                    onDismissRequest = { isVisibleDropdownMenu = false }
                ) {
                    listVariant.forEach {
                        DropdownMenuItem(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                isVisibleDropdownMenu = false
                                onClickItem(it)
                            },
                            content = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = it.toString(),
                                    style = MaterialTheme.typography.h2,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colors.primary
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ViewTitle(@StringRes stringId: Int) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(stringId),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.primary
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewLight() {
    AppTheme(
        themeMode = ThemeMode.LIGHT,
        colorScheme = ColorScheme.GREEN
    ) {
        SettingsScreen(
            SettingsContract.State(
                themeMode = ThemeMode.LIGHT,
                colorSchemeActive = ColorScheme.GREEN,
                numOneXe = 10
            )
        ) {}
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x00000000
)
@Composable
private fun PreviewDark() {
    AppTheme(
        themeMode = ThemeMode.AMOLED,
        colorScheme = ColorScheme.GREEN
    ) {
        SettingsScreen(
            SettingsContract.State(
                themeMode = ThemeMode.DARK,
                colorSchemeActive = ColorScheme.GREEN,
                numOneXe = 10
            )
        ) {}
    }
}