package dev.alexfranco.mtw.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_ciudades.*

class Ciudades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        btnGto.setOnClickListener(View.OnClickListener {
            this.tiempoCiudad(4005270, 20, "Pacialmente nublado")
        })

        btnIra.setOnClickListener(View.OnClickListener {
            this.tiempoCiudad(4004330, 20, "Pacialmente nublado")
        })
    }

    fun tiempoCiudad(ciudad:Int, grados:Int, estatus:String ) {
        val intentCiudad = Intent(this, MainActivity::class.java)
        intentCiudad.putExtra("ciudad", ciudad)
        intentCiudad.putExtra("grados", grados)
        intentCiudad.putExtra("estatus", estatus)
        startActivity(intentCiudad)
    }
}
