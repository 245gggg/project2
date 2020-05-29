
package com.example.android.project.category

import android.widget.ImageView

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.project.R
import com.example.android.project.database.Category_item


@BindingAdapter("categoryDuration")
fun TextView.setCategoryDurationFormatted(item: Category_item?) {
    item?.let {
        text = item.duration.toString()
    }
}

@BindingAdapter("categoryPrice")
fun TextView.setCategoryPriceFormatted(item: Category_item?) {
    item?.let {
        text = item.price.toString()
    }
}

@BindingAdapter("categoryTitle")
fun TextView.setSleepDurationFormatted(item: Category_item?) {
    item?.let {
        text = item.title
    }
}
@BindingAdapter("categoryImage")
fun ImageView.setCategotyImage(item: Category_item?) {
    item?.let {
        setImageResource(when (item.title){
            "Spagetti with Tomato sauce"-> R.drawable.sphagetti
               "Toast Hawaii"->R.drawable.toasthawaii
            "Classic Hamburger"->R.drawable.classichamburger
            "Asparagus Salad with Cherry Tomatoes"->R.drawable.asparagus
            "Wiener Schnitzel"->R.drawable.wiener
            "Delicious Orange Mousse"->R.drawable.deliciousorange
            "Pancakes"->R.drawable.pancakes
            "Creamy Indian Chicken Curry"->R.drawable.indianchicken
            "Chocolate Souffle"->R.drawable.chocolatescoffle
            "Salad with Smoked Salman"->R.drawable.saladsmoked
            else->R.drawable.ic_launcher_background
        })
      }
}





