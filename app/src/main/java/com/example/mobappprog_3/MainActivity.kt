package com.example.mobappprog_3

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val titles = arrayOf(
        "1) Респираторные инфекции",
        "2) Желудочно-кишечные инфекции",
        "3) Экзантематозные инфекции",
        "4) Инфекции печени",
        "5) Неврологические инфекции",
        "6) Геморрагическая лихорадка",
        "7) Инфекции кожи или слизистых оболочек",
        "8) Заболевания с множественным поражением различных систем и органов",
        "9) Неспецифическое фебрильное заболевание"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, titles)
        listView.isTextFilterEnabled = true

        listView.onItemClickListener = AdapterView.OnItemClickListener{
            a, v, position, id -> val intent = Intent()
            intent.setClass(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("title", position)

            startActivity(intent)
        }
    }
}