package com.main.presentation

//import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.app.ActionBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.main.presentation.ui.AppNavigation.AppNavigation
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        // installSplashScreen()
        setContent {
            ShoppingCartAppTheme {
                AppNavigation()
            }
        }
    }
}
