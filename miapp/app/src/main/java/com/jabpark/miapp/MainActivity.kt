package com.jabpark.miapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btnIrRegistro)
        boton.setOnClickListener {
            val intent = Intent(this, RegistrarIngresoActivity::class.java)
            startActivity(intent)
        }
    }
}
