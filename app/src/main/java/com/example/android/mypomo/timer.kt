package com.example.android.mypomo

import android.R
import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
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
 val timeedit = binding.editTextTime2
        val taskedit = binding.mourya


        binding.setButton.setOnClickListener {
            val time = timeedit.text.toString()
            val op = taskedit.text.toString()

            val task = "Task: $op"
            if (time.isEmpty()) {
                timeedit.error = "Please enter time!"
            }
            if (op.isEmpty()) {
                taskedit.error = "Please enter task!"
            }
           // if (check(time)) {
             //   timeedit.error = "Please enter time according to the given format."
        //    }
        else {
                 hideKeyboard()

                view?.findNavController()
                    ?.navigate(timerDirections.actionTimerToTiktock(time, true, task))
            }
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Set Time"
        return binding.root
    }


}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun check(time: String): Boolean {
    val timtim = arrayOf(time.split(":").toString())

    return !(time[2].toString() == ":" && timtim[0].toInt() < 60 && timtim[1].toInt() < 60)
}
