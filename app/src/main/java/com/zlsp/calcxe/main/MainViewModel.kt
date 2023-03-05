package com.zlsp.calcxe.main

import com.zlsp.calcxe.base.BaseViewModel
import com.zlsp.calcxe.data.repositories.theme.ThemeRepository
import com.zlsp.calcxe.domain.UserSettings
import com.zlsp.calcxe.main.MainContract.*
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val themeRepository: ThemeRepository) :
    BaseViewModel<State, Effect, Event>() {

    private val userSettings: UserSettings
        get() = themeRepository.userSettings

    override val containerHost: Container<State, Effect> = container(
        State(
            products = listOf(),
            userSettings = userSettings
        )
    )

    override fun sendEvent(event: Event) {
        when (event) {
            Event.UpdateConfig -> intent { reduce {
                println(userSettings)
                state.copy(userSettings = userSettings)
            } }
        }
    }
}