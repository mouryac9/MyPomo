package com.example.android.mypomo

import android.R
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.mypomo.databinding.FragmentTimerBinding


class timer : Fragment() {


    private lateinit var binding: FragmentTimerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            com.example.android.mypomo.R.layout.fragment_timer, container, false
        )
        val minedit = binding.editTextTime2
        val secedit = binding.editTextTime3
        val taskedit = binding.mourya


        binding.setButton.setOnClickListener {
            val task = "Task: ${taskedit.text}"
            if (minedit.text.toString().isEmpty() ) {
                minedit.error = "Please enter valid time!"
            }
            if (secedit.text.toString().isEmpty() ) {
                secedit.error = "Please enter valid time!"
            }
            if (taskedit.text.toString().isEmpty()) {
                taskedit.error = "Please enter task!"
           }
        else {
                hideKeyboard()

                view?.findNavController()
                    ?.navigate(
                        timerDirections.actionTimerToTiktock(
                            true,
                            task,
                            minedit.text.toString().toInt(),
                            secedit.text.toString().toInt()

                        )
                    )
                minedit.text=null
                secedit.text=null
                taskedit.text=null
            }
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Set Time"
        return binding.root
    }


}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}


fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}



