package com.aya.domain.repo

import com.aya.domain.entity.MealsResponse

interface MealsRepo {

    suspend fun getMealsFromRemote():MealsResponse

    suspend fun getMealsFromKtor(): Result<MealsResponse>


}