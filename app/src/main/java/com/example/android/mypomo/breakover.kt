package com.example.android.mypomo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.android.mypomo.databinding.ActivityMainBinding
import com.example.android.mypomo.databinding.FragmentBreakoverBinding
import com.example.android.mypomo.databinding.FragmentBreaktimeBinding


class breakover : Fragment() {


    private lateinit var binding: FragmentBreakoverBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentBreakoverBinding>(
            inflater,
            R.layout.fragment_breakover, container, false
        )

        binding.backButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_breakover_to_timer)
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.breakover1)
        return binding.root
    }
}