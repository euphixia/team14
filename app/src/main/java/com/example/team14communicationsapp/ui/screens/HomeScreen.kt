package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.team14communicationsapp.model.TagRepository
import com.example.team14communicationsapp.ui.components.ProfileBlurb
import com.example.team14communicationsapp.ui.components.ProfileImage
import com.example.team14communicationsapp.ui.components.TagCollection

@Composable
fun HomeScreen(name: String, major: String) {
    LazyColumn {
        item() {
            Row() {
                ProfileImage()
                ProfileBlurb(name, major)
            }
        }

        items(TagRepository.categories) { cat ->
            TagCollection(
                color = Color.Red,
                tagCategory = cat,
                tagContent = TagRepository.categoriesMap[cat].orEmpty()
            )
        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(name = "cutie pie", major = "mogging")
}
