package com.zlsp.calcxe.ui.screens.home

import com.zlsp.calcxe.ui.theme.ColorScheme
import com.zlsp.calcxe.ui.theme.ThemeMode

interface HomeContract {
    sealed interface Effect {
        class UpdateList(val id: Int) : Effect
    }

    sealed interface Event {
        class OnValueSearchChange(val enteredText: String) : Event
        class OnClickItemSearch(val id: Int) : Event
        class OnClickItemAddedProduct(val id: Int) : Event
        object OnClickCalc : Event
        object OnClickClearList : Event
    }

    data class State(
        val themeMode: ThemeMode,
        val colorSchemeActive: ColorScheme,
        val numOneXe: Int
    )
}