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

class SecondFragment : Fragment() {
    private lateinit var buttonScreen2 : Button
    companion object {
        fun newInstance() = SecondFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonScreen2 = view.findViewById(R.id.button_screen2)
        buttonScreen2.setOnClickListener {
            val fragmentManager : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

            val thirdFragment = ThirdFragment()
            val bundle = Bundle()
            bundle.putString("key","ini data dari fragment")
            val inputName = view.findViewById<EditText?>(R.id.editTextnama).text.toString()


            bundle.putString("key","Halo")
            bundle.putString("myname",inputName)

            thirdFragment.arguments = bundle

            fragmentTransaction.replace(R.id.container,thirdFragment,ThirdFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()


        }

    }


}