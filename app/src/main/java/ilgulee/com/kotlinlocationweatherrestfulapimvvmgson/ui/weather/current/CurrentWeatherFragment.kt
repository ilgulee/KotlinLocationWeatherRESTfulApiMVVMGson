package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.R
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.XUWeatherApiService
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel


        //just confirm if the retrofit returns the correct data
        val apiService = XUWeatherApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiService.getCurrentWeather("Seoul").await()
            text_test.text = response.toString()
        }

    }

}
