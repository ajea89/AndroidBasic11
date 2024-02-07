package com.ajea.module4androidbasic.intent

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ajea.module4androidbasic.R

class IntentReceiveExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_receive_extras)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val married = intent.getBooleanExtra("EXTRA_IS_MARRIED", false)
        var persona = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_PERSON", Persona::class.java)
        }else{
            intent.getSerializableExtra("EXTRA_PERSON") as Persona
        }

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = "Mi nombre es: $name $lastName, mi edad es: $age y ${if (married) "estoy casado" else "no estoy casado"}, mi alias es: ${persona?.alias ?: "No hay alias"}"

        val btReturnInfo = findViewById<Button>(R.id.btReturnInfo)
        btReturnInfo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_VALID", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }
}