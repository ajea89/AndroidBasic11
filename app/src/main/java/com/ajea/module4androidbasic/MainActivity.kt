package com.ajea.module4androidbasic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.ajea.module4androidbasic.intent.IntentImplicitoActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("CICLO_VIDA", "estoy en onCreate")

        val root = findViewById<ConstraintLayout>(R.id.root)

    }

    override fun onStart() {
        super.onStart()
        Log.e("CICLO_VIDA", "estoy en onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("CICLO_VIDA", "estoy en onResume")

        val intent = Intent(this, IntentImplicitoActivity::class.java)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        Log.e("CICLO_VIDA", "estoy en onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("CICLO_VIDA", "estoy en onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("CICLO_VIDA", "estoy en onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("CICLO_VIDA", "estoy en onDestroy")
    }
}