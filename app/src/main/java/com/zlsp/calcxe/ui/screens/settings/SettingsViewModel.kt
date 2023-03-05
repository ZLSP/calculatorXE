package com.zlsp.calcxe.ui.screens.settings

import com.zlsp.calcxe.base.BaseViewModel
import com.zlsp.calcxe.data.repositories.settings.SettingsRepository
import com.zlsp.calcxe.ui.screens.settings.SettingsContract.*
import com.zlsp.calcxe.ui.theme.ThemeMode
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val settingsRepository: SettingsRepository) :
    BaseViewModel<State, Effect, Event>() {

    override val containerHost: Container<State, Effect> =
        container(
            State(
                themeMode = settingsRepository.userSettings.themeMode,
                colorSchemeActive = settingsRepository.userSettings.colorScheme,
                numOneXe = settingsRepository.userSettings.numOneXe
            )
        )

    override fun sendEvent(event: Event) {
        when (event) {
            is Event.OnClickCheckBoxAmoledTheme -> intent {
                if (event.isCheck) {
                    settingsRepository.updateThemeMode(ThemeMode.AMOLED)
                    reduce { state.copy(themeMode = ThemeMode.AMOLED) }
                } else {
                    settingsRepository.updateThemeMode(ThemeMode.DARK)
                    reduce { state.copy(themeMode = ThemeMode.DARK) }
                }
                postSideEffect(Effect.UpdateConfiguration)
            }
            is Event.OnClickCheckBoxDarkTheme -> intent {
                if (event.isCheck) {
                    settingsRepository.updateThemeMode(ThemeMode.DARK)
                    reduce { state.copy(themeMode = ThemeMode.DARK) }
                } else {
                    settingsRepository.updateThemeMode(ThemeMode.LIGHT)
                    reduce { state.copy(themeMode = ThemeMode.LIGHT) }
                }
                postSideEffect(Effect.UpdateConfiguration)
            }
            is Event.OnClickColorScheme -> intent {
                postSideEffect(Effect.UpdateConfiguration)
                settingsRepository.updateColorScheme(event.colorScheme)
                reduce { state.copy(colorSchemeActive = event.colorScheme) }
            }
            is Event.OnValueChangeOneXeListener -> {
                intent {
                    settingsRepository.updateNumOneXe(event.numOneXe)
                    postSideEffect(Effect.UpdateConfiguration)
                    reduce { state.copy(numOneXe = event.numOneXe) }
                }
            }
        }
    }
}