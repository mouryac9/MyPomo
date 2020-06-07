package com.example.android.mypomo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.mypomo.databinding.FragmentCompleteBinding


class complete : Fragment() {

    private lateinit var binding: FragmentCompleteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentCompleteBinding>(
            inflater,
            R.layout.fragment_complete, container, false
        )

        binding.redoButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_complete_to_timer)
        }
        binding.breakButton.setOnClickListener { view: View ->
            view.findNavController().navigate(completeDirections.actionCompleteToBreaktime())
        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.complete1)
        return binding.root
    }

}