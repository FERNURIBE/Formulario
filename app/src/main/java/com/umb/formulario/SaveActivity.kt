package com.umb.formulario

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SaveActivity : AppCompatActivity() {

    //definimos las variables
    private lateinit var Names: EditText
    private lateinit var Data: EditText
    private lateinit var Add: Button
    private lateinit var Exit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_save)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Busca y asocia cada variable con su respectivo componente en el xml
        Names = findViewById(R.id.names)
        Data = findViewById(R.id.data)
        Exit= findViewById(R.id.exit)

        //Recibir datos enviados desde otra actividad.
        val datosMostrar = """
          Email: ${intent.getStringExtra("correo")}
          Reason registration: ${intent.getStringExtra("razon_curso")}
          Gender: ${intent.getStringExtra("genero")}
          Course: ${intent.getStringExtra("cursos")}
        """.trimIndent()

        val fullname = intent.getStringExtra("nombres")

        //Mostrar los datos en los campos de texto
        Names.setText(fullname ?: "Sin nombre")
        Data.setText(datosMostrar ?: "Sin datos")


        Add = findViewById(R.id.addother)
        //Asigna un evento al botón Add. Cuando el usuario lo presiona, se ejecuta la función
        Add.setOnClickListener {
            add()
        }


    }
    fun add() {
        finish()
    }

    fun exitApp(view: View) {
        finishAffinity() // Cierra toda la app
    }


}