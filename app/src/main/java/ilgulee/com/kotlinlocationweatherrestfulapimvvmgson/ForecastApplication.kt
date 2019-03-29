package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson

import android.app.Application


import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.db.ForecastDatabase
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network.*
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.repository.ForecastRepository
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

//Dependency Injection using Kodein

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) } //no need invoke()
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { XUWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
    }
}