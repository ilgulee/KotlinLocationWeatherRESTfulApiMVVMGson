package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network.response.CurrentWeatherResponse
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val xuWeatherApiService: XUWeatherApiService
) : WeatherNetworkDataSource {

    private val _downLoadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downLoadedCurrentWeather //auto cast to livedata

    override suspend fun fetchCurrentWeather(location: String, language: String) {
        try {
            val fetchedCurrentWeather = xuWeatherApiService
                .getCurrentWeather(location, language).await()
            _downLoadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}