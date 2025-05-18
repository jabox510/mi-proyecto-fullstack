package com.jabpark.miapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrarIngresoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val placaInput = findViewById<EditText>(R.id.editTextPlaca)
        val spinner = findViewById<Spinner>(R.id.spinnerTipo)
        val parqueaderoInput = findViewById<EditText>(R.id.editTextParqueadero)
        val boton = findViewById<Button>(R.id.btnRegistrar)

        // ✅ Este bloque carga los valores del arreglo "tipos" en el Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipos,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        boton.setOnClickListener {
            val placa = placaInput.text.toString()
            val tipo = spinner.selectedItem.toString()
            val parqueaderoId = parqueaderoInput.text.toString().toLongOrNull()

            if (placa.isNotEmpty() && parqueaderoId != null) {
                val vehiculo = Vehiculo(placa, tipo, Parqueadero(parqueaderoId))

                RetrofitClient.instance.registrarIngreso(vehiculo)
                    .enqueue(object : Callback<Vehiculo> {
                        override fun onResponse(call: Call<Vehiculo>, response: Response<Vehiculo>) {
                            Toast.makeText(this@RegistrarIngresoActivity, "Registrado con éxito", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<Vehiculo>, t: Throwable) {
                            Toast.makeText(this@RegistrarIngresoActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                        }
                    })
            } else {
                Toast.makeText(this, "Llena todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

