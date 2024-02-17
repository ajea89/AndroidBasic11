package com.ajea.module4androidbasic.fragments.params

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFinalBinding
    private var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("EXTRA_NAME"))
            name = intent.getStringExtra("EXTRA_NAME") ?: ""

        binding.tvContent.text = name
    }
}