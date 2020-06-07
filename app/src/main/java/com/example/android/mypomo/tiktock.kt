package com.example.android.mypomo

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.mypomo.databinding.FragmentTiktockBinding
import kotlin.properties.Delegates

class tiktock : Fragment() {

    private lateinit var binding: FragmentTiktockBinding


    var min by Delegates.notNull<Int>()
    var sec by Delegates.notNull<Int>()


    var frame by Delegates.notNull<Chronometer>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_tiktock,container,false)

        val args = tiktockArgs.fromBundle(arguments!!)
        val bool = args.bool
        min = args.minutes
        sec = args.seconds
        val task = args.task
       binding.textView10.text  = task


        frame = binding.chrmeter
        var isWorking = false

        binding.stopButton.setOnClickListener {
            if (!isWorking) {
                chrmeterstart()
                isWorking = true
            } else {
                chrmeterstop()
                isWorking = false
            }
            Toast.makeText(context, getString(
                if (isWorking)
                    R.string.working
                else
                    R.string.stopped),
                Toast.LENGTH_SHORT).show()
            binding.stopButton.setText(if (!isWorking) R.string.start else R.string.stop)
        }


        frame.onChronometerTickListener = OnChronometerTickListener {

                if(frame.text.toString().equals("00:01")) {
                    frame.stop()
                    when(bool){
                    true -> view?.findNavController()?.navigate(R.id.action_tiktock_to_complete)
                    false-> view?.findNavController()?.navigate(R.id.action_tiktock_to_breakover)

                }}
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.tiktock1)

        return binding.root    }

    private fun chrmeterstop() {
        frame.stop()
    }

    private fun chrmeterstart() {

        frame.base = SystemClock.elapsedRealtime()+ min *60*1000 + sec *1000
        frame.start()
    }


}


