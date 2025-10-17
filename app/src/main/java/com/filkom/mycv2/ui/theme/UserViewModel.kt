package com.filkom.mycv2.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.filkom.mycv2.data.UserData

class UserViewModel : ViewModel() {

    private val userList = mutableListOf<UserData>()
    var currentUser = mutableStateOf<UserData?>(null)
    var isFromRegister = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    // Daftar user lengkap
    fun registerUser(nim: String, nama: String, email: String, alamat: String, password: String): Boolean {
        if (nim.isBlank() || nama.isBlank() || email.isBlank() || alamat.isBlank() || password.isBlank()) {
            errorMessage.value = "Semua field harus diisi!"
            return false
        }
        if (userList.any { it.nim == nim }) {
            errorMessage.value = "NIM sudah terdaftar!"
            return false
        }

        val newUser = UserData(email, nim, nama, alamat, password)
        userList.add(newUser)
        currentUser.value = newUser
        isFromRegister.value = true
        errorMessage.value = ""
        return true
    }

    // Login user
    fun loginUser(email: String, password: String): Boolean {
        val user = userList.find { it.email == email && it.password == password }
        return if (user != null) {
            currentUser.value = user
            isFromRegister.value = false
            errorMessage.value = ""
            true
        } else {
            errorMessage.value = "Email atau password salah!"
            false
        }
    }
}
