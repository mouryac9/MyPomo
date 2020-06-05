package com.example.android.mypomo

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.mypomo.databinding.FragmentTiktockBinding
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tiktock.newInstance] factory method to
 * create an instance of this fragment.
 */
class tiktock : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentTiktockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        }
    lateinit var min:String
    lateinit var sec:String


var frame by Delegates.notNull<Chronometer>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTiktockBinding>(inflater,
            R.layout.fragment_tiktock,container,false)

        val args = tiktockArgs.fromBundle(arguments!!)
        val bool = args.bool
        val time = args.finaltime
        val task = args.task
       // binding.textView10.text  = "akshat"
        min  = time[0].toString() + time[1].toString()
        sec = (time[3].toString()) + (time[4].toString())

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
                    if(bool)
                    { view?.findNavController()?.navigate(R.id.action_tiktock_to_complete) }
                    else if(!bool)
                    { view?.findNavController()?.navigate(R.id.action_tiktock_to_breakover) }

                }
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.tiktock1)

        return binding.root    }

    private fun chrmeterstop() {
        view?.findNavController()?.navigate(R.id.action_tiktock_to_timer)
        frame.stop()


    }

    private fun chrmeterstart() {

        frame.base = SystemClock.elapsedRealtime()+ min.toInt()*60*1000 + sec.toInt()*1000
        frame.start()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tiktock.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tiktock().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


