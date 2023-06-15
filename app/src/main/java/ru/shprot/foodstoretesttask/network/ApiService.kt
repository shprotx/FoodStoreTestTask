package ru.shprot.foodstoretesttask.network

import retrofit2.Response
import retrofit2.http.GET
import ru.shprot.foodstoretesttask.data.categories.CategoryResponce
import ru.shprot.foodstoretesttask.data.dishes.DishesResponse

interface ApiService {

    @GET("/v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): Response<CategoryResponce>

    @GET("/v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): Response<DishesResponse>

}