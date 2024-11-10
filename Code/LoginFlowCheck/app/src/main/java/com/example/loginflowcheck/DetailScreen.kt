package com.example.loginflowcheck

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: DetailViewModel = hiltViewModel() // use hiltViewModel if you're using Hilt
) {
    val conditionMet by viewModel.conditionMet
    val message by viewModel.message

    val context = LocalContext.current

    val loginResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Notify LoginViewModel of success
//            loginViewModel.loginResult.value = true
            viewModel.meetCondition()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detail Screen") })
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("This is the Detail Screen")
                Text(text = message) // Display message from ViewModel

                Button(onClick = {
//                    viewModel.meetCondition() // Update condition in ViewModel
//                    viewModel.updateMessage("Condition met! Going to Home Screen...")
                    val intent = Intent(context, WebViewActivity::class.java)
                    loginResultLauncher.launch(intent)
                }) {
                    Text("Meet Condition and Go to Home")
                }

                // Check the condition and navigate back to Home if met
                if (conditionMet) {
                    // Reset condition in ViewModel and navigate
                    viewModel.updateMessage("Welcome to Detail Screen")
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            }
        }
    )
}

