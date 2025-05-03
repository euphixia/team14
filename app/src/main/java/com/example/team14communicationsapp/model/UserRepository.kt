package com.example.team14communicationsapp.model

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.team14communicationsapp.R
import javax.inject.Inject

class UserRepository @Inject constructor(){
    data class User(
        val name : String,
        val major : String,
        val profilePic : Int,
    )

    val emptyUser = User("name","major",R.drawable.ic_launcher_foreground)
    fun getAllUsers(): List<User> = listOf(
        User("cat", "nap", R.drawable.ic_launcher_foreground)
    )
}