package com.princemeher.flipstandclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

import android.content.res.Configuration
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Keep screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        
        // Immersive mode setup
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        val settingsManager = SettingsManager(this)

        setContent {
            val configuration = LocalConfiguration.current
            val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
            
            FlipStandClockTheme {
                if (isLandscape) {
                    val viewModel: ClockViewModel = viewModel(
                        factory = ClockViewModelFactory(settingsManager)
                    )
                    ClockScreen(
                        viewModel = viewModel,
                        onNavigateToSettings = {
                            // Manual navigation logic if needed
                        }
                    )
                } else {
                    SettingsScreen(settingsManager)
                }
            }
        }
    }
}

@Composable
fun FlipStandClockTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}
