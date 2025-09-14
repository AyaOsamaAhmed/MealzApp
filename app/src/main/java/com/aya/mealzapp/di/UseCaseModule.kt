package com.aya.mealzapp.di

import com.aya.domain.repo.MealsRepo
import com.aya.domain.usecase.getMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCase(mealsRepo: MealsRepo): getMeals {
        return getMeals(mealsRepo)
    }
}