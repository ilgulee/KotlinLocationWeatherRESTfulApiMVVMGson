package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.data.response

data class Condition(val text: String, val icon: String, val code: Int)

//api result
//    "condition": {
//        "text": "Overcast",
//        "icon": "//cdn.apixu.com/weather/64x64/day/122.png",
//        "code": 1009
//    }

