package com.aya.data.repo

import com.aya.data.remote.ApiService
import com.aya.domain.entity.MealsResponse
import com.aya.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote(): MealsResponse {
        return apiService.getMeals()
    }

}