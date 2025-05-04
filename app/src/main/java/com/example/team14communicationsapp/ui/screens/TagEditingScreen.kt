package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.team14communicationsapp.viewmodel.HomeViewModel

@Composable
fun TagEditingScreen(viewModel: HomeViewModel) {
    val state = viewModel.uiState.collectAsState().value

    Column(Modifier.padding(16.dp)) {
        state.tagMap.forEach { (category, tags) ->
            Text(text = category, Modifier.padding(8.dp))
            tags.forEach { tag ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.addTag(category, tag) }
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(tag)
                    Text("+")
                }
            }
        }
    }
}

@Preview
@Composable
private fun TagEditingScreenPreview(){
    //TagEditingScreen()
}