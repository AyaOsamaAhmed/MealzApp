package com.aya.mealzapp.di

import com.aya.data.remote.ApiService
import com.aya.data.repo.MealsRepoImpl
import com.aya.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): MealsRepo {
        return MealsRepoImpl(apiService)

    }
}