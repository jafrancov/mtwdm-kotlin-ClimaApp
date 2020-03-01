package dev.alexfranco.mtw.clima

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Network.hayRed(this)) {
//            Log.d("RED", "SI HAY RED")
            val ciudad = intent.getIntExtra("ciudad", 0)
            SolicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id=" + ciudad +"&appid=1ace0923dfe9ef4f381067ccdff63e7c&lang=es&units=metric")
        } else {
            Log.d("RED", "NO HAY RED")
            Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
        }

//        val ciudad = intent.getStringExtra("ciudad")
//        val grados = intent.getIntExtra("grados", 0)
//        val estatus = intent.getStringExtra("estatus")
//
//        txtCiudad.text = ciudad
//        txtGrados.text = grados.toString() + "º"
//        txtEstatus.text = estatus
    }

    private fun SolicitudHTTPVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                Log.d("Solicitud HTTP Volley", response)
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)
                txtCiudad.text = ciudad.name
                txtGrados.text = ciudad.main?.temp.toString() + "º"
                txtEstatus.text = ciudad.weather?.get(0)?.description
            } catch (e: Exception) {

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
