package com.ajea.module4androidbasic.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.ActivityBackBinding

class BackActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getStringExtra("EXTRA_USER")
        binding.tvUser.text = user
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                //Guardar en BD info
                onBackPressedDispatcher.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}