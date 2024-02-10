package com.ajea.module4androidbasic.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.ajea.module4androidbasic.R

class ComponentsSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components_selection)

        val cbMarried = findViewById<CheckBox>(R.id.cbMarried)
        val btShow = findViewById<Button>(R.id.btShow)
        val rgGenre = findViewById<RadioGroup>(R.id.rgGenre)
        val spinner = findViewById<Spinner>(R.id.spinner)


        cbMarried.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        rgGenre.setOnCheckedChangeListener { _, checkedId ->
            val idName = when(checkedId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "Checked id: $idName", Toast.LENGTH_LONG).show()
        }

        val datos = arrayListOf("Colombia", "Chile", "Argentina", "Peru","Estados Unidos")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, datos).also {
        it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }

        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = datos[position]
                Toast.makeText(this@ComponentsSelectionActivity, "Item Selected: $itemSelected", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ComponentsSelectionActivity, "Nada seleccionado", Toast.LENGTH_LONG).show()
            }
        }


        btShow.setOnClickListener {
            //CHECKBOX
            val cbStatus = cbMarried.isChecked
            //RADIOGROUP
            val rbSelected = when(rgGenre.checkedRadioButtonId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "D"
            }
            //SPINNER
            val itemSpinnerSelected = spinner.selectedItem
            Toast.makeText(this, "Selected = $itemSpinnerSelected", Toast.LENGTH_SHORT).show()
        }

    }
}