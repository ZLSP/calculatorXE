package com.zlsp.calcxe.main

import com.zlsp.calcxe.base.BaseViewModel
import com.zlsp.calcxe.data.repositories.theme.ThemeRepository
import com.zlsp.calcxe.main.MainContract.*
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(themeRepository: ThemeRepository) :
    BaseViewModel<State, Effect, Event>() {

    override val containerHost: Container<State, Effect> = container(
        State(
            products = listOf(),
            userSettings = themeRepository.userSettings
        )
    )

    override fun sendEvent(event: Event) {
    }
}