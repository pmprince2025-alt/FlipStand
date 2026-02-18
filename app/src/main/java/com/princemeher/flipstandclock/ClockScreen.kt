package com.princemeher.flipstandclock

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

@Composable
fun ClockScreen(
    viewModel: ClockViewModel = viewModel(),
    onNavigateToSettings: () -> Unit
) {
    val is24Hour by viewModel.is24HourFormat.collectAsState()
    val dimMode by viewModel.dimMode.collectAsState()
    
    val timeFormatted = viewModel.getTimeFormatted() // e.g., "12:34"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        onNavigateToSettings()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hours
            FlipDigit(timeFormatted.substring(0, 1))
            Spacer(Modifier.width(4.dp))
            FlipDigit(timeFormatted.substring(1, 2))
            
            // Separator
            Text(
                text = ":",
                color = Color.White,
                fontSize = 80.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            
            // Minutes
            FlipDigit(timeFormatted.substring(3, 4))
            Spacer(Modifier.width(4.dp))
            FlipDigit(timeFormatted.substring(4, 5))
        }

        // Dim Overlay
        if (dimMode) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
            )
        }
    }
}
