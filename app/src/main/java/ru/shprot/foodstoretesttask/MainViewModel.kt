package ru.shprot.foodstoretesttask

import androidx.lifecycle.ViewModel
import ru.shprot.foodstoretesttask.data.categories.CategoryItem
import ru.shprot.foodstoretesttask.data.dishes.DishesItem

object MainViewModel : ViewModel() {

    val categories = mutableListOf<CategoryItem>()
    val dishes = mutableListOf<DishesItem>()


    fun getAllCategories() {

    }

    fun getAllDishes() {

    }

}