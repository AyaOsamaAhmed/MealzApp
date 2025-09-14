package com.aya.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.domain.entity.MealsResponse
import com.aya.domain.usecase.getMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMealsUseCase: getMeals
): ViewModel(){

    private val  _category : MutableStateFlow<MealsResponse?> = MutableStateFlow<MealsResponse?>(null)
    val category : StateFlow<MealsResponse?> = _category

    fun getMeals(){
        viewModelScope.launch {
            try {
               _category.value =  getMealsUseCase()
            }catch (e : Exception){
                Log.e("MealsViewModel" , e.message.toString())
            }
        }
    }
}