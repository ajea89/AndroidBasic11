package com.ajea.module4androidbasic.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ajea.module4androidbasic.R


class IntentImplicitoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_implicito)


        val btSend = findViewById<Button>(R.id.btImplicitSend)
        val btSendUrl = findViewById<Button>(R.id.btSendUrl)

        btSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso urgente!!!")
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba de intent implicito para enviar")
            }

            startActivity(Intent.createChooser(emailIntent,"Enviar email..."))
            //Toast.makeText(this, "Prueba toast", Toast.LENGTH_SHORT).show()
        }



        btSendUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"))
            startActivity(Intent.createChooser(urlIntent,"Ver url..."))
            //Snackbar.make(btSend, "Prueba snackbar", 2000).show()
        }

    }
}