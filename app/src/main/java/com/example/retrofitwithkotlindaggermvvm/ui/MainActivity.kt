package com.example.retrofitwithkotlindaggermvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.retrofitwithkotlindaggermvvm.R
import com.example.retrofitwithkotlindaggermvvm.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        mainViewModel.getTodoList()
        mainViewModel.getResult().observe(this, Observer {
            mytv.text = it.get(0).title
            Toast.makeText(this,"Todo got",Toast.LENGTH_SHORT).show()
        })
        mainViewModel.geterror().observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
}
