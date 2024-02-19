package com.ajea.module4androidbasic.safeclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.ajea.module4androidbasic.databinding.ActivitySafeClickBinding

class SafeClickActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySafeClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySafeClickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSafe.setSafeOnClickListener {
            Toast.makeText(this, "Implementación de safe click", Toast.LENGTH_LONG).show()
        }

        binding.btProgress.setOnClickListener {
            updateViews(true)
            //Se da un dalay emulando el tiempo de alguna petición a API, BD o algun proceso
            Handler(Looper.getMainLooper()).postDelayed({
                updateViews(false)
                Toast.makeText(this, "Despues de 2 seg se oculta progress", Toast.LENGTH_LONG).show()
            }, 2000)
        }
    }
    private fun updateViews(isLoading: Boolean) {
        binding.progress.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.btSafe.isEnabled = !isLoading
        binding.btProgress.isEnabled = !isLoading
    }
}