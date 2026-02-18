package com.princemeher.flipstandclock

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsManager(private val context: Context) {

    companion object {
        val AUTO_START = booleanPreferencesKey("auto_start")
        val REQUIRE_CHARGING = booleanPreferencesKey("require_charging")
        val IS_24_HOUR = booleanPreferencesKey("is_24_hour")
        val DIM_MODE = booleanPreferencesKey("dim_mode")
    }

    val autoStart: Flow<Boolean> = context.dataStore.data.map { it[AUTO_START] ?: true }
    val requireCharging: Flow<Boolean> = context.dataStore.data.map { it[REQUIRE_CHARGING] ?: true }
    val is24Hour: Flow<Boolean> = context.dataStore.data.map { it[IS_24_HOUR] ?: true }
    val dimMode: Flow<Boolean> = context.dataStore.data.map { it[DIM_MODE] ?: false }

    suspend fun setAutoStart(value: Boolean) {
        context.dataStore.edit { it[AUTO_START] = value }
    }

    suspend fun setRequireCharging(value: Boolean) {
        context.dataStore.edit { it[REQUIRE_CHARGING] = value }
    }

    suspend fun set24HourFormat(value: Boolean) {
        context.dataStore.edit { it[IS_24_HOUR] = value }
    }

    suspend fun setDimMode(value: Boolean) {
        context.dataStore.edit { it[DIM_MODE] = value }
    }
}
