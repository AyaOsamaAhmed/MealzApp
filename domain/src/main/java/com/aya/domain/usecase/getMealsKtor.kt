package com.aya.domain.usecase

import com.aya.domain.entity.MealsResponse
import com.aya.domain.repo.MealsRepo

class getMealsKtor(private val repository: MealsRepo)  {

    suspend operator fun invoke(): Result<MealsResponse> {
        return repository.getMealsFromKtor()
    }

}