package com.lhh.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationItemView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationItemView=findViewById(R.id.navigation_view)
        val hostFragment: NavHostFragment=supportFragmentManager.findFragmentById(R.id.mhostfragment) as NavHostFragment
        val navController = hostFragment.navController

        bottomNavigationItemView.setupWithNavController(navController)



    }
}
