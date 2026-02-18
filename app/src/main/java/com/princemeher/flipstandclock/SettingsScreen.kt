import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(settingsManager: SettingsManager) {
    val autoStart = settingsManager.autoStart.collectAsState(initial = true)
    val requireCharging = settingsManager.requireCharging.collectAsState(initial = true)
    val is24Hour = settingsManager.is24Hour.collectAsState(initial = true)
    val dimMode = settingsManager.dimMode.collectAsState(initial = false)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp)
    ) {
        Text(
            text = "Settings",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        SettingsItem(
            title = "Auto Start on Charging",
            checked = autoStart.value,
            onCheckedChange = { scope.launch { settingsManager.setAutoStart(it) } }
        )
        
        SettingsItem(
            title = "Require Charging",
            checked = requireCharging.value,
            onCheckedChange = { scope.launch { settingsManager.setRequireCharging(it) } }
        )

        SettingsItem(
            title = "24-Hour Format",
            checked = is24Hour.value,
            onCheckedChange = { scope.launch { settingsManager.set24HourFormat(it) } }
        )

        SettingsItem(
            title = "Dim / Night Mode",
            checked = dimMode.value,
            onCheckedChange = { scope.launch { settingsManager.setDimMode(it) } }
        )
    }
}

@Composable
fun SettingsItem(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, color = Color.White, fontSize = 18.sp)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
    Divider(color = Color.DarkGray)
}
