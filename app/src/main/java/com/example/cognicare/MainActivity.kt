package com.example.cognicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cognicare.ui.DataUiModel
import com.example.cognicare.ui.HomeScreen
import com.example.cognicare.ui.LoginScreen
import com.example.cognicare.ui.ReportScreen
import com.example.cognicare.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CogniCare()
                }
            }
        }
    }
}

enum class Screen {
    Login,
    Home,
    Report
}

@Composable
fun CogniCare(
    viewModel: DataUiModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.name
    ) {
        composable(route = Screen.Login.name) {
            LoginScreen(viewModel) { navController.navigate(Screen.Home.name) }
        }
        composable(route = Screen.Home.name) {
            HomeScreen(viewModel) { navController.navigate(Screen.Report.name) }
        }
        composable(route = Screen.Report.name) {
            ReportScreen(viewModel)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CogniCarePreview() {
    AppTheme {
        CogniCare()
    }
}