package ru.shprot.foodstoretesttask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.shprot.foodstoretesttask.network.RetrofitInstance

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val viewModel = MainViewModel
        val apiService = RetrofitInstance.apiService

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.getCategories()
                if (response.isSuccessful) {
                    val answer = response.body()?.сategories
                    if (answer != null) {
                        viewModel.categories.addAll(answer)
                    }
                }
                val responseDishes = apiService.getDishes()
                if (responseDishes.isSuccessful) {
                    val answer = responseDishes.body()?.dishes
                    if (answer != null) {
                        viewModel.dishes.addAll(answer)
                    }
                }
                withContext(Dispatchers.Main) {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
            } catch (e: Exception) {
                Log.d("MyLog", "Error occurred: ${e.message}")
            }
        }
    }
}