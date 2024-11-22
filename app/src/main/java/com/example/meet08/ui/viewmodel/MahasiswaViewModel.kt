package com.example.meet08.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meet08.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel : ViewModel() {

    private val _mahasiswaStateUI =
        MutableStateFlow(Mahasiswa())

    val mahasiswaStateUI:
            StateFlow<Mahasiswa> =
        _mahasiswaStateUI.asStateFlow()


}