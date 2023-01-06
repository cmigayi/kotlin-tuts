package com.example.kotlinmanualdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainContainer = MainContainer((application as RandomizeApplication)
            .applicationContainer.numberRespository)
        val viewModel = ViewModelProvider(this, mainContainer.getMainViewModelFactory())
            .get(MainViewModel::class.java)

        viewModel.getLiveData().observe(this, Observer {
            findViewById<TextView>(R.id.activity_main_text_view).text = it.toString()
        })

        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            viewModel.generateNextNumber()
        }
    }
}