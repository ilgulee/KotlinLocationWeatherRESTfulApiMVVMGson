package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network

import androidx.lifecycle.LiveData
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    suspend fun fetchCurrentWeather(
        location: String,
        language: String
    )
}