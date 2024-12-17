package com.platzi.android.mvvm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme
import com.platzi.android.mvvm.core.navigation.NavigationRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlatziCaloriesTheme {
                val navController = rememberNavController()
                NavigationRoot(
                    navHostController = navController
                )
            }
        }
    }
}