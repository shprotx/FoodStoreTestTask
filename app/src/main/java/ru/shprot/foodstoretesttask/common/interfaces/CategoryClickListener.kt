package ru.shprot.foodstoretesttask.common.interfaces

import ru.shprot.foodstoretesttask.data.categories.CategoryItem

interface CategoryClickListener {
    fun onItemClicked(item: CategoryItem)
}