package com.example.team14communicationsapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import javax.inject.Inject

class UserRepository @Inject constructor(){
    data class User(
        val name: String = "name",
        val major: String = "major",
        val profilePic: ImageVector? = null,
    )

    data class PicOptions(
        val star: ImageVector = Icons.Outlined.Star,
        val person : ImageVector = Icons.Outlined.Person,
        val face : ImageVector = Icons.Outlined.Face
    )



    public val emptyUser = User("name","major", null)
    fun getAllUsers(): List<User> = listOf(
        User("cat", "nap", Icons.Filled.Star)
    )

}