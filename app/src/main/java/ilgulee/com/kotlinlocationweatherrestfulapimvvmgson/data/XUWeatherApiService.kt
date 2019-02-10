package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.BuildConfig
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = BuildConfig.API_KEY
const val BASE_URL = BuildConfig.BASE_URL

interface XUWeatherApiService {

    //http://api.apixu.com/v1/current.json?key=API_KEY&q=London&lang=en

    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>  //Kotlin coroutines

    companion object {
        operator fun invoke(): XUWeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory()) //because of Deferred
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(XUWeatherApiService::class.java)
        }
    }
}