package com.zlsp.calcxe.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zlsp.calcxe.navigation.Screen
import com.zlsp.calcxe.ui.screens.settings.SettingsScreen
import com.zlsp.calcxe.ui.screens.settings.SettingsViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainContent(
    navHostController: NavHostController = rememberNavController(),
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = { AppBottomBar(navHostController) }
    ) { scaffoldPadding ->
        NavHost(
            modifier = Modifier.padding(scaffoldPadding),
            navController = navHostController,
            startDestination = Screen.HOME.route
        ) {
            composable(Screen.HOME.route) {

            }
            composable(Screen.SETTINGS.route) {
                val viewModel = hiltViewModel<SettingsViewModel>()
                val state by viewModel.collectAsState()
                SettingsScreen(state, viewModel::sendEvent)
            }
            composable(Screen.LIST.route) {

            }
        }
    }
}

@Composable
fun AppBottomBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        elevation = 20.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val screens = listOf(
            Screen.SETTINGS,
            Screen.HOME,
            Screen.LIST
        )
        screens.forEach { screen ->
            val isActiveScreen =
                currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                selected = isActiveScreen,
                icon = { Icon(painterResource(screen.iconId), null) },
                enabled = !isActiveScreen,
                label = { Text(stringResource(screen.labelId)) },
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}