package com.example.clase3listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var listView: ListView
    private lateinit var button: Button

    private lateinit var nombre: String
    private lateinit var nacion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        listView = findViewById(R.id.listView)
        button = findViewById(R.id.button)

        val nombres = listOf("Pepe", "Lorena", "Luciano", "Tomas", "Carolina", "Juancito")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nombres)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                nombre = nombres[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val nacionalidad = listOf("Chile", "Bolivia", "Colombia", "Argentina", "Paraguay")
        val adapterListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, nacionalidad)
        listView.adapter = adapterListView

        listView.setOnItemClickListener { adapterView, view, i, l ->
            nacion = nacionalidad[i]
        }

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", nombre)
            intent.putExtra("nacionalidad", nacion)
            startActivity(intent)
        }
    }
}