package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.ui.weather.current

import androidx.lifecycle.ViewModel;
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.repository.ForecastRepository
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.internal.UnitSystem
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC //get from settings later

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
