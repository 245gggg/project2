package com.example.android.project.category

import android.app.Application
import android.icu.util.ULocale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.project.database.CategoryDatabaseDao
import com.example.android.project.category.CategoryViewModel
class CategoryViewModelFactory(
    private val dataSource: CategoryDatabaseDao,
    private val application: Application,
    private val id:Int) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(dataSource, application,id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
