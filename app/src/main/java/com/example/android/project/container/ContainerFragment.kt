package com.example.android.project.container

import android.annotation.SuppressLint
import android.icu.text.CaseMap
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager

import com.example.android.project.R
import com.example.android.project.databinding.CategoryFragmentBinding


import com.example.android.project.databinding.ContainerFragmentBinding


class ContainerFragment : Fragment() {
    private lateinit var viewModel: ContainerViewModel

    companion object {
        fun newInstance() = ContainerFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ContainerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.container_fragment, container, false)
       viewModel = ViewModelProviders.of(this).get(ContainerViewModel::class.java)


        val adapter = ContainerAdapter(ContainerListener { nightId ->

            viewModel.onCategoryClicked(nightId)
        })

        binding.containerList.adapter = adapter


        binding.setLifecycleOwner(this)

        val manager = GridLayoutManager(activity, 2)
        binding.containerList.layoutManager=manager

        adapter.submitList(viewModel.categories)

        (activity as AppCompatActivity).supportActionBar?.title = "Meals"

        setHasOptionsMenu(true)


        // Specify the current activity as the lifecycle owner of the binding.
        // This is necessary so that the binding can observe LiveData updates.
        //
        viewModel.navigateToCategoryDetail.observe(viewLifecycleOwner, Observer { night ->
            night?.let {
               var title:String=""
                for (cat in viewModel.categories){
                    if(cat.id==night){
                        title=cat.title
                    }
                }
                this.findNavController().navigate(
                    ContainerFragmentDirections.actionContainerFragmentToCategoryFragment(night,title))
                viewModel.onCategoryDetailNavigated()
            }
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContainerViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu, menu)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
