package ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ilgulee.com.kotlinlocationweatherrestfulapimvvmgson.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment) //like container
        bottom_nav.setupWithNavController(navController) //connect container to bottom nav
        NavigationUI.setupActionBarWithNavController(this, navController) //using arrow in toolbar
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null) //no up arrow from current main activity
    }
}
