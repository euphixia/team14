package com.example.team14communicationsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.toRoute
import com.example.team14communicationsapp.ui.screens.Screen.HomeScreen
import com.example.team14communicationsapp.ui.screens.Screen.SimilarUsersScreen
import com.example.team14communicationsapp.ui.screens.Screen.TagEditingScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen{
    @Serializable
    data object HomeScreen: Screen()

    @Serializable
    data object SimilarUsersScreen: Screen()

    @Serializable
    data object TagEditingScreen: Screen()

    fun NavBackStackEntry.toScreen(): Screen? =
        when (destination.route?.substringAfterLast(".")?.substringBefore("/")) {
            "HomeScreen" -> toRoute<HomeScreen>()
            "TagEditingScreen" -> toRoute<TagEditingScreen>()
            "SimilarUsersScreen" -> toRoute<SimilarUsersScreen>()
            else -> null
        }
}

