package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.team14communicationsapp.model.TagRepository
import com.example.team14communicationsapp.ui.components.ProfileBlurb
import com.example.team14communicationsapp.ui.components.ProfileImage
import com.example.team14communicationsapp.ui.components.TagCollection
import com.example.team14communicationsapp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.tagMap.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading...")
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ProfileImage(
                        profilePic = uiState.userProfilePic,
                        onClick = {
                            navController.navigate(Screen.ProfilePicOptionsScreen)
                        }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ProfileBlurb(
                        name = uiState.userName,
                        major = uiState.userMajor,
                        onNameChange = { viewModel.updateUserName(it) },
                        onMajorChange = { viewModel.updateUserMajor(it) },
                        isEditable = true
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = "Your Tags",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                )
            }


            if (uiState.tagCategory.isNotEmpty() && uiState.tags.isNotEmpty()) {
                items(uiState.tagCategory.size) { index ->
                    TagCollection(
                        color = Color.Red,
                        tagCategory = uiState.tagCategory[index],
                        tagContent = uiState.tags[index]
                    )
                }
            } else {
                item {
                    Text(
                        text = "No tags found.",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    //HomeScreen()
}
