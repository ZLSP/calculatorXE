package com.zlsp.calcxe.main

import androidx.lifecycle.ViewModel
import com.zlsp.calcxe.data.repositories.settings.SettingsRepository
import com.zlsp.calcxe.data.repositories.theme.ThemeRepository
import com.zlsp.calcxe.main.MainContract.*
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (themeRepository: ThemeRepository) :
    ContainerHost<State, Effect>, ViewModel() {
    override val container: Container<State, Effect> = container(State(
        products = listOf(),
        userSettings = themeRepository.userSettings
    ))
}