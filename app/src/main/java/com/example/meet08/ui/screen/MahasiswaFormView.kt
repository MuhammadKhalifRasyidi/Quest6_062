package com.example.pertemuan8.ui.screen

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

import com.example.meet08.R

@Composable
fun MahasiswaFormView(
    modifier: Modifier,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {

    var nim by remember {
        mutableStateOf("")
    }
    var nama by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var listData: MutableList<String> =
        mutableListOf(nim, nama, email)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.primary)
            ),
    ) {

    }
}