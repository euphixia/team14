package com.example.team14communicationsapp.ui.components

// Source : Most of the code here is from Cornell APPDEV's Intro to Android Course,
// specifically code from Assignment 5

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Source : Most of the code here is from Cornell APPDEV's Intro to Android Course,
// specifically code from Assignment 5

@Composable
fun UploadImageCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
//    https://www.geeksforgeeks.org/create-different-types-of-circle-in-canvas-in-android-using-jetpack-compose/    // 1. OUTLINED CIRCLE
    Row(Modifier
        .fillMaxWidth()
        .height(100.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = Color.LightGray,
                center = _root_ide_package_.androidx.compose.ui.geometry.Offset(
                    x = canvasWidth / 6,
                    y = canvasHeight / 2
                ),
                radius = size.minDimension/3,
                style= Stroke(10F)
            )

        }
    }
//    Surface(
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(3.dp, Color.Blue),
//        color = Color.White,
//        modifier = modifier,
//        onClick = onClick,
//        shadowElevation = 2.dp
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//        ) {
//            Text(
//                text = "( + )",
//                modifier = Modifier.align(Alignment.Center),
//                fontWeight = FontWeight.Bold,
//                color = Color.Blue,
//                fontSize = 26.sp
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun UploadImageCardPreview() {
    UploadImageCard() {}
}
