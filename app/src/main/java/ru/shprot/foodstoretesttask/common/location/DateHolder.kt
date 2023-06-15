package ru.shprot.foodstoretesttask.common.location

import android.icu.text.SimpleDateFormat
import java.util.*

class DateHolder {

    fun getCurrentDate() : String {

        val date = Date()
        val formatter = SimpleDateFormat("d MMMM, yyyy", Locale("ru", "RU"))

        return formatter.format(date)

    }

}