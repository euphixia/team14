package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.team14communicationsapp.model.TagRepository
import com.example.team14communicationsapp.ui.components.ProfileBlurb
import com.example.team14communicationsapp.ui.components.ProfileImage
import com.example.team14communicationsapp.ui.components.TagCollection
import com.example.team14communicationsapp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    // grab UI state
    val uiState by viewModel.uiState
    LazyColumn {
        item() {
            Row() {
                ProfileImage()
                ProfileBlurb(uiState.userName, uiState.userMajor)
            }
        }

        items(uiState.tagMap.size) { index ->
            TagCollection(
                color = Color.Red,
                tagCategory = uiState.tagCategory[index],
                tagContent = uiState.tags[index]
            )
        }
    }

}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
