package com.aya.domain.repo

import com.aya.domain.entity.MealsResponse

interface MealsRepo {

    fun getMealsFromRemote():MealsResponse


}