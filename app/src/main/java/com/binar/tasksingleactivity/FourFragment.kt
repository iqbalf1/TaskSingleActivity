package com.binar.tasksingleactivity

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FourFragment : Fragment() {
    lateinit var buttonScreen4: Button

    companion object {
        fun newInstance() = FourFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.four_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager : FragmentManager = parentFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val dataname = arguments?.getString("key")
        buttonScreen4 = view.findViewById(R.id.button_screen4)
        buttonScreen4.setOnClickListener {

            val thirdFragment = ThirdFragment()
            val bundle = Bundle()
            bundle.putString("key","ini data dari fragment")

            val inputAge = view.findViewById<EditText>(R.id.editTextusia).text.toString()
            val inputAddress =  view.findViewById<EditText>(R.id.editTextalamat).text.toString()
            val inputPekerjaan = view.findViewById<EditText>(R.id.editTextpekerjaan).text.toString()

            bundle.putString("myname",dataname)
            bundle.putString("MyAge",inputAge)
            bundle.putString("MyAddress",inputAddress)
            bundle.putString("MyJob",inputPekerjaan)

            thirdFragment.arguments = bundle

            fragmentTransaction.replace(R.id.container,thirdFragment,ThirdFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}