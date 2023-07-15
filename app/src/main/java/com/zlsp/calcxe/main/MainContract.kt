package com.zlsp.calcxe.main

import com.zlsp.calcxe.domain.UserSettings

interface MainContract {

    sealed interface Effect

    sealed interface Event

    data class State(
        val products: List<String>,
        val userSettings: UserSettings
    )
    
}