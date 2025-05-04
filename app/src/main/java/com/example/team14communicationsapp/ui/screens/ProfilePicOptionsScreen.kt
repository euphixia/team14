package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.team14communicationsapp.model.UserRepository
import com.example.team14communicationsapp.viewmodel.HomeViewModel

@Composable
fun ProfilePicOptionsScreen(
navController: NavController,
viewModel: HomeViewModel = hiltViewModel()
) {
    val icons = listOf(
        Icons.Outlined.Star,
        Icons.Outlined.Person,
        Icons.Outlined.Face
    )

    Column {
        Text("Pick a new profile icon:")

        icons.forEach { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        viewModel.changeProfilePic(icon)
                        navController.popBackStack()
                    }
                    .size(64.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilePicOptionsScreenPreview(){
    //ProfilePicOptionsScreen()
}
