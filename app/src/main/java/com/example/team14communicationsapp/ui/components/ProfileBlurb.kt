package com.example.team14communicationsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileBlurb(
    name: String,
    major: String,
    onNameChange: (String) -> Unit,
    onMajorChange: (String) -> Unit,
    isEditable: Boolean = true
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth().padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                if (isEditable) {
                    androidx.compose.material3.TextField(
                        value = name,
                        onValueChange = onNameChange,
                        textStyle = TextStyle(
                            fontSize = 40.sp),
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(1f),
                        singleLine = true
                    )
                } else {
                    Text(
                        text = name,
                        fontSize = 40.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                if (isEditable) {
                    androidx.compose.material3.TextField(
                        value = major,
                        onValueChange = onMajorChange,
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(1f),
                        singleLine = true
                    )
                } else {
                    Text(
                        text = major,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileBlurbPreview() {
    //ProfileBlurb(name = "Cat", major = "Sleeping")
}