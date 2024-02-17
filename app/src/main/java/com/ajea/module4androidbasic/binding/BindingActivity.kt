package com.ajea.module4androidbasic.binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Iniciar sesión"
        supportActionBar?.setDisplayShowTitleEnabled(true)

        binding.tvTitle.text = "Ingresa tu usuario"

        binding.btSend.setOnClickListener {
            if (binding.etUser.text.isEmpty()){
                Toast.makeText(this, "Debes ingresar datos", Toast.LENGTH_LONG).show()
            }else{
                val nextActivity = Intent(this, BackActivity::class.java).apply {
                    putExtra("EXTRA_USER", binding.etUser.text.toString())
                }
                startActivity(nextActivity)
            }
        }
    }
}