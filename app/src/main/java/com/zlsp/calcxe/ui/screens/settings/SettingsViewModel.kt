package com.zlsp.calcxe.ui.screens.settings

import com.zlsp.calcxe.base.BaseViewModel
import com.zlsp.calcxe.data.repositories.settings.SettingsRepository
import com.zlsp.calcxe.ui.screens.settings.SettingsContract.Effect
import com.zlsp.calcxe.ui.screens.settings.SettingsContract.Event
import com.zlsp.calcxe.ui.screens.settings.SettingsContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
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
            is Event.OnClickCheckBoxThemeMode -> intent {
                settingsRepository.updateThemeMode(event.themeMode)
                reduce { state.copy(themeMode = event.themeMode) }
            }

            is Event.OnClickColorScheme -> intent {
                settingsRepository.updateColorScheme(event.colorScheme)
                reduce { state.copy(colorSchemeActive = event.colorScheme) }
            }

            is Event.OnValueChangeOneXeListener -> {
                intent {
                    settingsRepository.updateNumOneXe(event.numOneXe)
                    reduce { state.copy(numOneXe = event.numOneXe) }
                }
            }
        }
    }
}