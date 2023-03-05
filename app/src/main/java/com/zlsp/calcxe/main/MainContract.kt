package com.zlsp.calcxe.main

import com.zlsp.calcxe.domain.UserSettings

interface MainContract {
    sealed interface Effect{
        object Navigate: Effect
    }
    sealed interface Event{
        object UpdateConfig: Event
    }
    data class State(
        val products: List<String>,
        val userSettings: UserSettings
    )
}