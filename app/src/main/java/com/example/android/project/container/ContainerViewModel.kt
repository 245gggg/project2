package com.example.android.project.container

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContainerViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    private val _navigateToCategoryDetail = MutableLiveData<Int>()
    val navigateToCategoryDetail
        get() = _navigateToCategoryDetail

    fun onCategoryDetailNavigated() {
        _navigateToCategoryDetail.value = null
    }
    var categories= listOf<Category>(
        Category(1,"Italain"),Category(2,"Quick and Easy"),Category(3,"Hamburgers"),
        Category(4,"German"),Category(5,"LightAndLovely"),Category(6,"Exotic"),
        Category(7,"Breakfast"),Category(8,"Asian"),Category(9,"French"),
        Category(10,"Summer")
    )

  fun onCategoryClicked(id:Int){
    _navigateToCategoryDetail.value=id
  }
}
