package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Detail(
    nim: String,
    nama: String,
    onDaftar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Detail")
        Spacer(modifier = Modifier.height(16.dp))
        Text("NIM: $nim")
        Text("Nama: $nama")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onDaftar, modifier = Modifier.fillMaxWidth()) {
            Text("Daftar")
        }
    }
}
