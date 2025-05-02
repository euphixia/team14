package com.example.team14communicationsapp.model

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.team14communicationsapp.R
import javax.inject.Inject

class UserRepository @Inject constructor(){
    data class User(
        val name : String,
        val major : String,
        val profilePic : ImageVector,
    )

    data class PicOptions(
        val star: ImageVector = Icons.Outlined.Star,
        val person : ImageVector = Icons.Outlined.Person,
        val face : ImageVector = Icons.Outlined.Face
    )



    val emptyUser = User("name","major", Icons.Filled.Person)
    fun getAllUsers(): List<User> = listOf(
        User("cat", "nap", Icons.Outlined.Star)
    )

}