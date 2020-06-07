package com.example.android.mypomo

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.mypomo.databinding.FragmentStarterBinding


class starter : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentStarterBinding>(inflater,
            R.layout.fragment_starter,container,false)

        binding.startButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(starterDirections.actionStarterToTimer())
        }
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.starter1)
        (activity as AppCompatActivity).supportActionBar?.setIcon(R.drawable.ic_baseline_access_alarm_24)
        return binding.root    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}