package com.ajea.module4androidbasic.componentesgraficos.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.module4androidbasic.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val userList = findViewById<RecyclerView>(R.id.userList)

        val userDataList = arrayListOf(
            User("Alan","1234567", "ajea89@gmail.com", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            User("Jose","1234567", "jose@gmail.com", ""),
            User("Elias","1234567", "elias@gmail.com", ""),
            User("Luis","1234567", "luis@gmail.com", ""),
            User("Mariana","1234567", "mariana@gmail.com", ""),
            User("Eva","1234567", "eva@gmail.com", ""),
            User("Eva","1234567", "eva@gmail.com", ""),
            User("Eva","1234567", "eva@gmail.com", ""),
            User("Eva","1234567", "eva@gmail.com", ""),
            User("Eva","1234567", "eva@gmail.com", "")
        )

        val adapter = UserAdapter(userDataList)
        adapter.onItemSelected = {
            Toast.makeText(this, "User selected = ${it.name}", Toast.LENGTH_LONG).show()
        }

        userList.adapter = adapter
        userList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}