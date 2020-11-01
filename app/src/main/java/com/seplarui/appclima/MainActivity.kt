package com.seplarui.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? =null
    var tvGrados:TextView?=null
    var tvEstatus:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.seplarui.appclima.ciudades.CIUDAD")
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        val ciudadmx = Ciudad("Ciudad de México", 15, "Soleado")
        val ciudadBerlin = Ciudad("Ciudad de Berlin", 20, "Cielo despejado")

        if(ciudad=="ciudad-mexico") {
            //Mostrar informacion ciudadmx
            tvCiudad?.text=ciudadmx.nombre
            tvGrados?.text=ciudadmx.grados.toString() + "º"
            tvEstatus?.text=ciudadmx.estatus

        } else if(ciudad =="ciudad-berlin") {
            tvCiudad?.text=ciudadBerlin.nombre
            tvEstatus?.text=ciudadBerlin.estatus
            tvGrados?.text=ciudadBerlin.grados.toString() + "º"

        } else {
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()
        }
    }
}