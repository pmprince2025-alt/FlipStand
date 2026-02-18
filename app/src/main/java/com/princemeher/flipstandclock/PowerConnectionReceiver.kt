package com.princemeher.flipstandclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Configuration

class PowerConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == Intent.ACTION_POWER_CONNECTED) {
            // Check if in landscape
            val config = context.resources.configuration
            if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                val launchIntent = Intent(context, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(launchIntent)
            }
        }
    }
}
