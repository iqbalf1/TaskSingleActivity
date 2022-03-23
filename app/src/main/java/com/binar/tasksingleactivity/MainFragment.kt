package com.binar.tasksingleactivity

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainFragment : Fragment() {
    private lateinit var buttonScreen1: Button
    private lateinit var viewModel: MainViewModel
    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        buttonScreen1 = view.findViewById(R.id.button_screen1)
        buttonScreen1.setOnClickListener {
            val fragmentManager : FragmentManager =  parentFragmentManager
            val fragmentTransaction  :  FragmentTransaction =  fragmentManager.beginTransaction()

            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("key","data dari fragment1")
            secondFragment.arguments =bundle

            fragmentTransaction.replace(R.id.container,secondFragment,SecondFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }

}