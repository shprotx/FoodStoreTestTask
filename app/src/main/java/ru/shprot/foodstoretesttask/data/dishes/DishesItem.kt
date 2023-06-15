package ru.shprot.foodstoretesttask.data.dishes

data class DishesItem(
    val id : Int,
    val name : String,
    val price : Int,
    val weight : Int,
    val description : String,
    val image_url : String,
    val tegs : Array<String>
)