package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.repository

import androidx.lifecycle.LiveData
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}