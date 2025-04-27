package com.example.team14communicationsapp.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(name: String, major: String){
    LazyColumn {
        item(){
            Row(){

            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    HomeScreen(name ="cutie pie", major="mogging")
}
