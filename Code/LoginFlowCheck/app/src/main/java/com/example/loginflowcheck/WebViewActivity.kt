package com.example.loginflowcheck

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavHostController
import com.example.loginflowcheck.ui.theme.LoginFlowCheckTheme
import dagger.hilt.android.AndroidEntryPoint

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.e("shohag", "Ok go to the pavilion now")
        val intent = Intent()
        setResult(RESULT_OK, intent)
        finish()
//        setContent {
//            LoginFlowCheckTheme {
//                HomeScreenForWeb()
//            }
//        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenForWeb() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home Screen") })
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("This is the Home Screen")
                Button(onClick = {}) {
                    Text("Go to Detail")
                }
            }
        }
    )
}