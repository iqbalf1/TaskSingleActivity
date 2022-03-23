package com.binar.tasksingleactivity

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ThirdFragment : Fragment() {
    lateinit var buttonScreen3 : Button
    companion object {
        fun newInstance() = ThirdFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager : FragmentManager = parentFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val dataName = arguments?.getString("myname")
        val dataNameTextView = view.findViewById<TextView>(R.id.textName)
        dataNameTextView.text = dataName

        buttonScreen3 = view.findViewById(R.id.button_screen3)
        buttonScreen3.setOnClickListener {
            val fourFragment = FourFragment()
            val bundle = Bundle()

            bundle.putString("key",dataName)
            fourFragment.arguments = bundle
            
            fragmentTransaction.replace(R.id.container,fourFragment,fourFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        //Manggil dari Fragment 4


        val dataAge = arguments?.getString("MyAge")
        val dataAddress = arguments?.getString("MyAddress")
        val dataJob = arguments?.getString("MyJob")

        val usia = dataAge?.toInt()
        val value : String
        if (usia != null ){
            value =  if (usia %2 == 0)
            {
                "$dataAge,DATA DANDA GENAP"
            }else{
                "$dataAge, DATA ANDA GANJIL"
            }
            val dataUsiaTextView = view.findViewById<TextView>(R.id.textViewusia)
            dataUsiaTextView.text = value
        }


        val dataAlamatTextView = view.findViewById<TextView>(R.id.textViewalamat)
        val dataPekerjaanTextView = view.findViewById<TextView>(R.id.textviewpekerjaan)


        dataAlamatTextView.text = dataAddress
        dataPekerjaanTextView.text = dataJob

    }

}