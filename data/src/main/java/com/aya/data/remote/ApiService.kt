package com.aya.data.remote

import com.aya.domain.entity.MealsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun  getMeals(): MealsResponse
}