package com.example.android.project.category

import android.icu.util.ULocale
import com.example.android.project.category.CategoryFragmentArgs
import com.example.android.project.category.CategoryViewModel



import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.project.R
import com.example.android.project.database.CategoryDatabase
import com.example.android.project.databinding.CategoryFragmentBinding
import com.example.android.project.category.CategoryViewModelFactory
import com.example.android.project.container.Category
import com.example.android.project.database.Category_item


class CategoryFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: CategoryFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.category_fragment, container, false)


        val arguments = arguments?.let { CategoryFragmentArgs.fromBundle(it) }
        val id:Int= arguments?.id ?: 0
        val title:String=arguments?.Title?:"meals"

        (activity as AppCompatActivity).supportActionBar?.title = title


        val application = requireNotNull(this.activity).application
        val dataSource = CategoryDatabase.getInstance(application).categoryDatabaseDao
        val viewModelFactory = CategoryViewModelFactory(dataSource, application,id)
        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(CategoryViewModel::class.java)



        binding.categoryViewModel = viewModel

        val adapter = CategoryAdapter(CategoryListener { nightId ->

            viewModel.onCategoryListClicked(nightId)
        })
        binding.categoryList.adapter = adapter
        viewModel.categories_detected.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })


        binding.setLifecycleOwner(this)



       viewModel.navigateToCategory.observe(viewLifecycleOwner, Observer { night ->
            night?.let {
                this.findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToDetailFragment(night))
                viewModel.doneNavigating()
            }
        })



        val manager = GridLayoutManager(activity, 1)
        binding.categoryList.layoutManager = manager


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
