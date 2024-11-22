package com.example.meet08.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meet08.ui.screen.RencanaStudiView
import com.example.meet08.ui.screen.SplashView
import com.example.meet08.ui.screen.ViewHasil
import com.example.meet08.ui.viewmodel.MahasiswaViewModel
import com.example.meet08.ui.viewmodel.RencanaStudiViewModel
import com.example.pertemuan8.ui.screen.MahasiswaFormView

enum class PengelolaHalaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsStateUi = krsViewModel.krsUiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = PengelolaHalaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = PengelolaHalaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(
                    PengelolaHalaman.Mahasiswa.name
                )
            })
        }
        composable(route = PengelolaHalaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(PengelolaHalaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = PengelolaHalaman.Matakuliah.name) {
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                    krsViewModel.saveDataKRS(it)
                    navController.navigate(PengelolaHalaman.Tampil.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = PengelolaHalaman.Tampil.name) {
            ViewHasil(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = krsStateUi,
                onBackButtonClicked = {
                    navController.navigate(PengelolaHalaman.Splash.name) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
