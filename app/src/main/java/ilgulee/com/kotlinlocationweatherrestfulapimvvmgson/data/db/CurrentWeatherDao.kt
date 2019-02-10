package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.entity.CURRENT_WEATHER_ID
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.entity.CurrentWeatherEntry
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.unitlocalized.ImperialCurrentWeatherEntry
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry) //update or insert

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}
