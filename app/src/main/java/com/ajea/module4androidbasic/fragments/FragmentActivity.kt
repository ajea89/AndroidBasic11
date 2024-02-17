package com.ajea.module4androidbasic.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer2, Binding2Fragment.newInstance())
            .addToBackStack("SecondFragment")
            .commit()


    }
}