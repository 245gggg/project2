
package com.example.android.project.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_list_table")
data class Category_item(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "category_ids")
        val category_ids:Int = 0,
        @ColumnInfo(name = "preparation_details")
        var preparation_details: String = "",
        @ColumnInfo(name = "ingredients")
        var ingredients:String = "",
        @ColumnInfo(name = "title")
        var title:String = "",
        @ColumnInfo(name = "favourite")
        var favourite:Boolean = false
)
