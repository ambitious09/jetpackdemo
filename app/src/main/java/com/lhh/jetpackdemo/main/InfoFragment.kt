package com.lhh.jetpackdemo.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.lhh.jetpackdemo.R
import com.lhh.jetpackdemo.adapter.shoeAdapter
import com.lhh.jetpackdemo.databinding.FragmentInfoBinding
import com.lhh.jetpackdemo.model.ShoeModel
import com.lhh.jetpackdemo.utils.CustomViewModelProvider
import com.lhh.jetpackdemo.utils.ShoeModelFactory

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {

    private  val viewmodel: ShoeModel by viewModels {
        CustomViewModelProvider.providerShoeModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentInfoBinding.inflate(inflater,container,false)
        context?:return binding.root
        ViewModelProviders.of(this,  CustomViewModelProvider.providerShoeModel(requireContext())).get(ShoeModel::class.java)
        val adapter = shoeAdapter()
        binding.recycler.adapter = adapter
        onSubscribeUi(adapter)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onSubscribeUi(adapter: shoeAdapter) {

        viewmodel.shoes.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.submitList(it)
            }
        })

    }



}
