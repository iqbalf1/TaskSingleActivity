package com.binar.tasksingleactivity

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFragment()

    }private fun firstFragment(){

        //Buat Instance dari Fragment Manager
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val  firstFragment = MainFragment()
        //Menambahkan  frame
        fragmentTransaction.add(R.id.container,firstFragment,MainFragment::class.java.simpleName)
        fragmentTransaction.commit()
        fragmentTransaction.addToBackStack(null)

    }
}