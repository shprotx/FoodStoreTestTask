package ru.shprot.foodstoretesttask.common.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class LocationHolder {

    @SuppressLint("MissingPermission")
    fun getCurrentCity(context: Context, callback: (city: String) -> Unit) {

        val fusedLocationClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

        fusedLocationClient.lastLocation.addOnSuccessListener { location : Location? ->
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses: MutableList<Address>? =
                location?.let { geocoder.getFromLocation(it.latitude, location.longitude, 1) }
            val currentCity = addresses?.get(0)?.locality ?: "Unknown location"
            callback(currentCity)
        }
    }

}