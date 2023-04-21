package com.example.clase3listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewNombre: TextView
    private lateinit var textViewNacion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val nacionalidad = bundle?.getString("nacionalidad") ?: ""

        textViewNombre = findViewById(R.id.textViewNombre)
        textViewNacion = findViewById(R.id.textViewNacionalidad)

        textViewNombre.text = nombre
        textViewNacion.text = nacionalidad
    }
}