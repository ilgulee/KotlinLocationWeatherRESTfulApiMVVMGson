package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.network

import android.content.Context
import android.net.ConnectivityManager
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {
    private val appContext =
        context.applicationContext  //not depending on components but depending on app application context

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnectionAvailable())
            throw NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun isConnectionAvailable(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}