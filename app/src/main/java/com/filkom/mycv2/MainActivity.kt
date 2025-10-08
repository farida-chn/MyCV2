package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.filkom.mycv2.screen.Login
import com.filkom.mycv2.screen.Detail
import com.filkom.mycv2.screen.Daftar
import com.filkom.mycv2.ui.theme.MyCV2Theme

object NavDestination {
    const val Login = "login"
    const val Detail = "detail/{nim}/{nama}"
    const val Daftar = "daftar"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCV2Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavDestination.Login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(NavDestination.Login) {
                            Login(
                                onLogin = { nim, nama ->
                                    navController.navigate("detail/$nim/$nama")
                                },
                                onDaftar = { navController.navigate(NavDestination.Daftar) }
                            )
                        }
                        composable(
                            route = "detail/{nim}/{nama}",
                            arguments = listOf(
                                navArgument("nim") { type = NavType.StringType },
                                navArgument("nama") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val nim = backStackEntry.arguments?.getString("nim") ?: ""
                            val nama = backStackEntry.arguments?.getString("nama") ?: ""
                            Detail(
                                nim = nim,
                                nama = nama,
                                onDaftar = { navController.navigate(NavDestination.Daftar) }
                            )
                        }
                        composable(NavDestination.Daftar) {
                            Daftar(
                                onSimpan = {
                                    // Simpan → kembali ke halaman login atau detail sesuai kebutuhan
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MyCV2Theme {}
}
