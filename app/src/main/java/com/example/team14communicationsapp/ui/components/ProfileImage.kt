package com.example.team14communicationsapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileImage( onClick : () -> Unit) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .clip(CircleShape)
            .background(color = Color.LightGray)
            .padding(3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight().background(color = Color.LightGray)
        ) {
            Text(
                text = "+",
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                fontSize = 8.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileImagePreview() {
    ProfileImage(onClick = {-> null})
}