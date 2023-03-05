package com.zlsp.calcxe.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.zlsp.calcxe.ui.MainContent
import com.zlsp.calcxe.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            val state by viewModel.collectAsState()
            val sendGlobalEvent = viewModel::sendEvent
            AppTheme(
                themeMode = state.userSettings.themeMode,
                colorScheme = state.userSettings.colorScheme,
                content = { MainContent { sendGlobalEvent(it) } }
            )
        }
    }
}