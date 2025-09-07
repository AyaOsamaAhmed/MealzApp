package com.aya.domain.usecase

import com.aya.domain.entity.MealsResponse
import com.aya.domain.repo.MealsRepo

class getMeals(private val repository: MealsRepo)  {

    suspend operator fun invoke(): MealsResponse {
        return repository.getMealsFromRemote()
    }

}