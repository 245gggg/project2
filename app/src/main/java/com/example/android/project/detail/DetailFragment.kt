package com.example.android.project.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.project.R
import com.example.android.project.database.CategoryDatabase
import com.example.android.project.databinding.DetailFragmentBinding


class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false)
        val arguments = arguments?.let { DetailFragmentArgs.fromBundle(it) }
        val id:Int= arguments?.id ?: 0
        val application = requireNotNull(this.activity).application
        val dataSource = CategoryDatabase.getInstance(application).categoryDatabaseDao
        val viewModelFactory = DetailViewModelFactory(dataSource, application,id)
        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(DetailViewModel::class.java)
        viewModel.categoryItem.observe(viewLifecycleOwner, Observer { category->category?.
        let{
            val adap: ArrayAdapter<String>
            val items:ArrayList<String>
            items= stringTowords(category.preparation_details) as ArrayList<String>
            adap = context?.let { it1 -> ArrayAdapter<String>(it1,android.R.layout.simple_list_item_1, items) }!!
            binding.ingredientslist.setAdapter(adap)
            val adap1: ArrayAdapter<String>
            val items1:ArrayList<String>
            items1= stringTowords(category.ingredients) as ArrayList<String>
            adap1 = context?.let { it1 -> ArrayAdapter<String>(it1,android.R.layout.simple_list_item_1, items1) }!!

            (activity as AppCompatActivity).supportActionBar?.title = category.title
            binding.stepslist.setAdapter(adap1)
            binding.imageView.setImageResource(when (category.title){
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

        }})

        return binding.root
    }
    fun stringTowords(s:String)=s.trim().splitToSequence(',').filter { it.isNotEmpty() }.toList()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
