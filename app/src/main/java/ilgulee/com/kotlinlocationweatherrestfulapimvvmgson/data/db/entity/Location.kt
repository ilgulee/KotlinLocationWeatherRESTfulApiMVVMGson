package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.entity

import com.google.gson.annotations.SerializedName

class Location(

    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,

    @SerializedName("tz_id")
    val tzId: String,

    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long,

    val localtime: String

)