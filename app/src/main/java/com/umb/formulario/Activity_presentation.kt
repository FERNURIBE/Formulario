package com.umb.formulario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_presentation : AppCompatActivity() {

    //definimos variables
    private lateinit var Register: Button

    //Metodo on create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_presentation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.presentation)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }



        //Busca y asocia cada variable con su respectivo componente en el xml
        Register = findViewById(R.id.register)

        // Asignar evento de clic al botón
        Register.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
