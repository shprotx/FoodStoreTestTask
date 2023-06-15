package ru.shprot.foodstoretesttask.ui.cart

import androidx.lifecycle.ViewModel
import ru.shprot.foodstoretesttask.data.dishes.DishesItem

object CartViewModel : ViewModel() {

    private val orderedDishes = mutableListOf<DishesItem>()
    private val numberOfDishes = mutableListOf<Int>()



    fun addDish(item: DishesItem) {

        if (orderedDishes.contains(item)) {
            val position = orderedDishes.indexOf(item)
            numberOfDishes[position]++
        } else {
            orderedDishes.add(item)
            numberOfDishes.add(1)
        }

    }




    fun removeDish(position: Int) {

        orderedDishes.removeAt(position)
        numberOfDishes.removeAt(position)

    }




    fun getAllDishes() = orderedDishes




    fun removeAllDishes() {

        orderedDishes.clear()
        numberOfDishes.clear()

    }




    fun getNumberOfDishes() = orderedDishes.size




    fun incrementDishNumber(position: Int) : Int {

        numberOfDishes[position]++
        return numberOfDishes[position]

    }




    fun decrementDishNumber(position: Int) : Int {

        numberOfDishes[position]--

        if (numberOfDishes[position] == 0) {
            removeDish(position)
            return 0
        }

        return numberOfDishes[position]

    }




    fun getDishNumber(position: Int) = numberOfDishes[position]




    fun getFullPrice() : Int {

        var price = 0

        for (i in orderedDishes) {
            val position = orderedDishes.indexOf(i)
            val number = numberOfDishes[position]
            val sum = i.price * number
            price += sum
        }

        return price

    }

}