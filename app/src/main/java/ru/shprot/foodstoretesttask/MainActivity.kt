package ru.shprot.foodstoretesttask

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import ru.shprot.foodstoretesttask.databinding.ActivityMainBinding
import ru.shprot.foodstoretesttask.ui.account.AccountFragment
import ru.shprot.foodstoretesttask.ui.cart.CartFragment
import ru.shprot.foodstoretesttask.ui.home.MainFragment
import ru.shprot.foodstoretesttask.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)

        binding.bottomNav.setOnItemSelectedListener { item ->

            navController.navigate(item.itemId)
            return@setOnItemSelectedListener true

        }

    }


}