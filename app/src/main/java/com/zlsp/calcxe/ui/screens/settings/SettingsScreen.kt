package com.zlsp.calcxe.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

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
            onClick = { sendEvent(SettingsContract.Event.OnClickCheckBoxDarkTheme(it)) }
        )
        Spacer(Modifier.height(PADDING_VIEW.dp))
        ViewSettingsItemCheckbox(
            nameId = R.string.settingsAmoledMode,
            isCheck = state.themeMode == ThemeMode.AMOLED,
            onClick = { sendEvent(SettingsContract.Event.OnClickCheckBoxAmoledTheme(it)) }
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
    val gridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        state = gridState,
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
        Button (
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorScheme.set.getPalette(themeMode).switch().primary
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
                    tint = colorScheme.set.getPalette(themeMode).switch().onPrimary
                )
            }
        }
    }

}

@Composable
private fun ViewSettingsItemCheckbox(
    @StringRes nameId: Int,
    isCheck: Boolean,
    onClick: (Boolean) -> Unit
) {
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
            onCheckedChange = onClick,
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