package com.example.team14communicationsapp.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.team14communicationsapp.ui.screens.Screen

data class NavItem(
    val screen: Screen,
    val label: String,
    val icon: ImageVector
)

val tabs = listOf(
    NavItem(
        label="Home",
        icon= Icons.Filled.Home,
        screen = Screen.HomeScreen,
    ),
    NavItem(
        label="Tag Editing",
        icon= Icons.Filled.AddCircle,
        screen = Screen.TagEditingScreen
    ),
    NavItem(
        label="Similar Users",
        icon = Icons.Filled.Face,
        screen = Screen.SimilarUsersScreen
    )
)