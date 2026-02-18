package com.princemeher.flipstandclock

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val DigitalFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Share Tech Mono"),
        fontProvider = provider
    )
)

@Composable
fun FlipDigit(
    value: String,
    modifier: Modifier = Modifier
) {
    var previousValue by remember { mutableStateOf(value) }
    var currentValue by remember { mutableStateOf(value) }
    
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(value) {
        if (value != currentValue) {
            previousValue = currentValue
            currentValue = value
            rotation.snapTo(0f)
            rotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    Box(
        modifier = modifier
            .width(100.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        // Static Background (Bottom half of new value, Top half of old value)
        Column(Modifier.fillMaxSize()) {
            DigitHalf(previousValue, isTop = true)
            DigitHalf(currentValue, isTop = false)
        }

        // Flipping Part
        val angle = rotation.value
        if (angle <= 90f) {
            // Flipping down from top (shows old value top)
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationX = -angle
                        cameraDistance = 8 * density
                    }
            ) {
                Column(Modifier.fillMaxSize()) {
                    DigitHalf(previousValue, isTop = true)
                    Spacer(Modifier.weight(1f))
                }
            }
        } else {
            // Flipping down to bottom (shows new value bottom)
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationX = 180f - angle
                        cameraDistance = 8 * density
                    }
            ) {
                Column(Modifier.fillMaxSize()) {
                    Spacer(Modifier.weight(1f))
                    DigitHalf(currentValue, isTop = false)
                }
            }
        }
        
        // Divider line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black.copy(alpha = 0.5f))
                .align(Alignment.Center)
        )
    }
}

@Composable
fun DigitHalf(
    value: String,
    isTop: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(
                if (isTop) RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                else RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            )
            .background(Color(0xFF1A1A1A)),
        contentAlignment = if (isTop) Alignment.BottomCenter else Alignment.TopCenter
    ) {
        // To show only half, we use a large negative offset or clipping
        Box(
            modifier = Modifier.height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                color = Color.White,
                fontSize = 100.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DigitalFontFamily,
                modifier = Modifier.offset(y = if (isTop) (-37).dp else 37.dp)
            )
        }
    }
}
