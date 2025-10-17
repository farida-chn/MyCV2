package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.filkom.mycv2.viewmodel.UserViewModel

@Composable
fun DetailScreen(navController: NavController, viewModel: UserViewModel) {
    val user = viewModel.currentUser.value
    val fromRegister = viewModel.isFromRegister.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 20.dp)
    ) {
        Text("DETAIL", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        if (user != null) {
            if (fromRegister) {
                // tampil lengkap: NIM, Nama, Email, Alamat
                Text("NIM: ${user.nim}", fontSize = 16.sp)
                Text("Nama: ${user.nama}", fontSize = 16.sp)
                Text("Email: ${user.email}", fontSize = 16.sp)
                Text("Alamat: ${user.alamat}", fontSize = 16.sp)
            } else {
                // hanya email
                Text("Email: ${user.email}", fontSize = 16.sp)
            }
        } else {
            Text("Tidak ada data user", fontSize = 16.sp)
        }

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Kembali ke Login")
        }
    }
}
