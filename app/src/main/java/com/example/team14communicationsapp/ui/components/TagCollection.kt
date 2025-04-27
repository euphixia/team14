package com.example.team14communicationsapp.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TagCollection(
    color: Color,
    tagCategory: String,
    tagContent: List<String>
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .weight(.3f)
                    .background(color = color)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = tagCategory,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    LazyHorizontalGrid(
                        rows = GridCells.Adaptive(50.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        items(tagContent) { content ->
                            Text(
                                text = content,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TagCollectionPreview() {
    TagCollection(
        color = Color.Red,
        tagCategory = "Clubs",
        tagContent = listOf("Taekwondo", "App Dev", "CU Figure Skating", "URMC")
    )
}