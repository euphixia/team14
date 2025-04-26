package com.example.team14communicationsapp.ui.screens

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen{
    @Serializable
    data object HomeScreen: Screen()

    @Serializable
    data object SimilarUsersScreen: Screen()

    @Serializable
    data object TagEditingScreen: Screen()
}