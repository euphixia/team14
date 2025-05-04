package com.example.team14communicationsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//TODO figure out how to make the plus the default but once there is an image the Text goes away
@Composable
fun ProfileImage(
    profilePic: ImageVector?,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(Color.DarkGray)
            .padding(3.dp),
        shape = CircleShape,
        color = Color.Transparent,
        shadowElevation = 2.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray, shape = CircleShape)
        ) {
            if (profilePic == null) {
                // Default icon
                Text(
                    text = "+",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black,
                    fontSize = 45.sp
                )
            } else {
                // User-selected icon
                Icon(
                    imageVector = profilePic,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .align(Alignment.Center),
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileImagePreview() {
    ProfileImage(profilePic= Icons.Filled.Star, onClick = {-> null})
}