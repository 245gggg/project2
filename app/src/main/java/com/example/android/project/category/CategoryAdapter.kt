


package com.example.android.project.category

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.project.database.Category_item
import com.example.android.project.databinding.CategoryListItemBinding
import com.example.android.project.databinding.ContainerListItemBinding



class CategoryAdapter(val clickListener: CategoryListener) : ListAdapter<Category_item,CategoryAdapter.ViewHolder>(CategoryListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CategoryListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Category_item, clickListener: CategoryListener) {
            binding.categoryItem=item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CategoryListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class CategoryListDiffCallback : DiffUtil.ItemCallback<Category_item>() {

    override fun areItemsTheSame(oldItem: Category_item, newItem: Category_item): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Category_item, newItem: Category_item): Boolean {
        return oldItem == newItem
    }
}


class CategoryListener(val clickListener: (sleepId: Int) -> Unit) {
    fun onClick(night:Category_item) = clickListener(night.id)
}
