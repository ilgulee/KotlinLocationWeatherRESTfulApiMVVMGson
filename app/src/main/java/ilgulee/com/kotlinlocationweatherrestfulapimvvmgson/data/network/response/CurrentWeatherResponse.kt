package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network.response

import com.google.gson.annotations.SerializedName
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.entity.CurrentWeatherEntry
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.entity.Location

data class CurrentWeatherResponse(

    val location: Location,

    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)
