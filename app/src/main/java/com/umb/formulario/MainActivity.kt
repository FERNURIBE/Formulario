package com.umb.formulario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var Name: EditText
    private lateinit var Email: EditText
    private lateinit var Reason: EditText
    private lateinit var Courses: Spinner
    private lateinit var Gender: RadioGroup
    private lateinit var Female: RadioButton
    private lateinit var Male: RadioButton
    private lateinit var Save: Button
    private lateinit var Exit: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Busca y asocia cada variable con su respectivo componente en el xml
        Name = findViewById(R.id.name)
        Email = findViewById(R.id.email)
        Reason = findViewById(R.id.reason_course)
        Courses = findViewById(R.id.courses)
        Gender = findViewById(R.id.gender)
        Female = findViewById(R.id.female)
        Male = findViewById(R.id.male)
        Save = findViewById(R.id.save)
        Exit= findViewById(R.id.exit)


        //Condicionales
        Save.setOnClickListener {
            if (Name.text.toString().isEmpty() || Email.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter names and email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show()

                //Se crea un Intent que permite cambiar de la actividad actual a SaveActivity.
                val intent = Intent(this, SaveActivity::class.java)
                intent.putExtra("nombres", Name.text.toString())
                intent.putExtra("correo", Email.text.toString())
                intent.putExtra("cursos", Courses.selectedItem.toString())
                intent.putExtra("razon_curso", Reason.text.toString())

                // Definir la variable género correctamente
                var genero = if (Male.isChecked) "Male" else "Female"

                // Agregar el género al intent
                intent.putExtra("genero", genero)

                // Iniciar la actividad
                startActivity(intent)
                limpiar()
            }


        }

    }
    fun limpiar() {
        Name.setText("")
        Email.setText("")
        Reason.setText("")
        Courses.setSelection(0)
        Gender.clearCheck()
        Name.requestFocus()
    }

    fun exitApp(view: View) {
        finishAffinity() // Cierra toda la app
    }



}