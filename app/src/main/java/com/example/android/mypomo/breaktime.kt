package com.example.android.mypomo

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.mypomo.databinding.FragmentBreaktimeBinding


class breaktime : Fragment() {


    private lateinit var binding: FragmentBreaktimeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            binding = DataBindingUtil.inflate<FragmentBreaktimeBinding>(inflater,
            R.layout.fragment_breaktime,container,false)
        val min= binding.editTextTime
        val sec= binding.editTextTime4
        binding.enjoyButton.setOnClickListener{

            if (min.text.toString().isEmpty()) {
                min.error ="Please enter valid time!"
            }
            if (sec.text.toString().isEmpty() ) {
                sec.error = "Please enter valid time!"
            }
            else {
            view?.findNavController()
                ?.navigate(breaktimeDirections.actionBreaktimeToTiktock( false, "Break time!!", min.text.toString().toInt(), sec.text.toString().toInt()))
        }}
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.breaktime1)
        return binding.root    }


}