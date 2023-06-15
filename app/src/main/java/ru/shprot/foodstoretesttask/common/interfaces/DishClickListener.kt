package ru.shprot.foodstoretesttask.common.interfaces

import ru.shprot.foodstoretesttask.data.dishes.DishesItem

interface DishClickListener {

    fun onDishClicked(item : DishesItem)

}