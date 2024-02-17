package com.ajea.module4androidbasic.fragments.params

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.ActivityParamsBinding

class ParamsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityParamsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerParams, SendParamsFragment.newInstance())
            .commit()
    }
}