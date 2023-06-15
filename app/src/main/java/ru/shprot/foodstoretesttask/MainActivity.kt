package ru.shprot.foodstoretesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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

        binding.bottomNav.setOnItemSelectedListener { item ->
            val builder = NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(false)
            val navGraph = navController.currentDestination?.parent
            val destination = navGraph?.findNode(item.itemId)
            if(item.order and Menu.CATEGORY_SECONDARY == 0)
                navController.graph.findStartDestination().id.let {
                    builder.setPopUpTo(it, inclusive = false, saveState = true)
                }

            val navOptions = builder.build()
            destination?.id.let {
                if (it != null) {
                    navController.navigate(it, null, navOptions)
                }
            }
            return@setOnItemSelectedListener true
        }

    }


}