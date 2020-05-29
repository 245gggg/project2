package com.example.android.project.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.project.category.CategoryViewModel
import com.example.android.project.database.CategoryDatabaseDao

class DetailViewModelFactory(
    private val dataSource: CategoryDatabaseDao,
    private val application: Application,
    private val id:Int) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dataSource, application,id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}