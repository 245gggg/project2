package com.example.android.project.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.android.project.database.CategoryDatabaseDao
import com.example.android.project.database.Category_item


import androidx.lifecycle.LiveData
import kotlinx.coroutines.Job
class DetailViewModel(
    private val dataSource: CategoryDatabaseDao,
    private val application: Application,
    private val id:Int): ViewModel() {
    val database = dataSource
    private val viewModelJob = Job()
     val categoryItem: LiveData<Category_item>

    init {
        categoryItem=database.getNightWithId(id)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}