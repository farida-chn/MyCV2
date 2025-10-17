package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filkom.mycv2.screen.*
import com.filkom.mycv2.viewmodel.UserViewModel
import com.filkom.mycv2.ui.theme.MyCV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCV2Theme {
                val navController = rememberNavController()
                val userViewModel: UserViewModel = viewModel()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            navController = navController,
                            viewModel = userViewModel
                        )
                    }
                    composable("daftar") {
                        DaftarScreen(
                            navController = navController,
                            viewModel = userViewModel
                        )
                    }
                    composable("detail") {
                        DetailScreen(
                            navController = navController,
                            viewModel = userViewModel
                        )
                    }
                }
            }
        }
    }
}
