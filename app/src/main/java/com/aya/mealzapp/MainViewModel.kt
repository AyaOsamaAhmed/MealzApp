package com.aya.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.aya.domain.entity.Category
import com.aya.domain.entity.MealsResponse
import com.aya.domain.usecase.getMeals
import com.aya.domain.usecase.getMealsKtor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMealsUseCase: getMeals,
    private val getMealsKtorUseCase: getMealsKtor,
): ViewModel(){

    private val  _category : MutableStateFlow<MealsResponse?> = MutableStateFlow<MealsResponse?>(null)
    val category : StateFlow<MealsResponse?> = _category
    private val  _listCategory : MutableStateFlow<List<Category>?> = MutableStateFlow<List<Category>?>(null)

    var listCategory : StateFlow<List<Category>?> = _listCategory


    init {
        getMeals()
        getMealsKtor()
        //default()

       /* _listCategory.value = listOf(
            Category("USA", "Washington D.C.","",""),
            Category("France", "null","",""),
            Category("Japan", "Tokyo","",""),
            Category("Brazil", "null","","")
        )

        listCategory = _listCategory

        Log.d("MealsViewModel", "default: $listCategory")
        */
    }

    private fun getMeals(){
        viewModelScope.launch {
            try {
               _category.value =  getMealsUseCase()
             //   _listCategory.value = _category.value?.categories
             //   listCategory = _listCategory

                Log.d("MealsViewModel", "getMeals: $listCategory")
            }catch (e : Exception){
                Log.e("MealsViewModel" , e.message.toString())
            }
        }
    }

    private fun getMealsKtor(){
        viewModelScope.launch {
            try {
              val result =  getMealsKtorUseCase()
                result.onSuccess {
                    _category.value = it
                    _listCategory.value = _category.value?.categories
                    listCategory = _listCategory
                }
                Log.d("MealsViewModelKtor", "getMeals: ${result}")
            }catch (e : Exception){
                Log.e("MealsViewModelKtor" , e.message.toString())
            }
        }
    }
}