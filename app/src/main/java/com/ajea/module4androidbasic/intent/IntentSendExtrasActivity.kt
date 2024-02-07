package com.ajea.module4androidbasic.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.ajea.module4androidbasic.R

class IntentSendExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_send_extras)

        val btSendExtras = findViewById<Button>(R.id.btSendExtras)
        btSendExtras.setOnClickListener {
            val sendIntent = Intent(this, IntentReceiveExtrasActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Alan")
                putExtra("EXTRA_LASTNAME", "Espinosa")
                putExtra("EXTRA_AGE", 34)
                putExtra("EXTRA_IS_MARRIED", false)
                putExtra("EXTRA_PERSON", Persona("Alan", "AJEA"))
            }
            //startActivity(sendIntent)
            resultRegister.launch(sendIntent)
        }
    }

    private val resultRegister = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            Toast.makeText(this, "resultCode = ${result.resultCode}, es valido?: ${result.data?.getBooleanExtra("EXTRA_IS_VALID", false)}", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }
}