package com.example.team14communicationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.team14communicationsapp.ui.screens.HomeScreen
import com.example.team14communicationsapp.ui.screens.ProfilePicOptionsScreen
import com.example.team14communicationsapp.ui.screens.Screen
import com.example.team14communicationsapp.ui.theme.Team14CommunicationsAppTheme
import com.example.team14communicationsapp.viewmodel.tabs
import com.example.team14communicationsapp.ui.screens.Screen.HomeScreen.toScreen
import com.example.team14communicationsapp.ui.screens.TagEditingScreen
import com.example.team14communicationsapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Team14CommunicationsAppTheme {

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    NavigationBar {
                        tabs.map { item ->
                            NavigationBarItem(
                                selected = item.screen == navBackStackEntry?.toScreen(),
                                onClick = { navController.navigate(item.screen) },
                                icon = { Icon(imageVector = item.icon, contentDescription = null) },
                                label = { Text(text = item.label) }
                            )
                        }
                    }
                }) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val homeViewModel: HomeViewModel = hiltViewModel()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.HomeScreen
                        ) {

                            composable<Screen.HomeScreen> {
                                HomeScreen(
                                    navController = navController,
                                    viewModel = homeViewModel
                                )
                            }
                            composable<Screen.ProfilePicOptionsScreen> {
                                ProfilePicOptionsScreen(
                                    navController = navController,
                                    viewModel = homeViewModel
                                )
                            }
                            composable<Screen.TagEditingScreen> {
                                TagEditingScreen(viewModel = homeViewModel)
                            }
                            composable<Screen.SimilarUsersScreen> {
                                Text(text = "SIMILARUSESCREEN : add your screen here")
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Team14CommunicationsAppTheme {
            Greeting("Android")
        }
    }
}