package com.example.raulmacias.klima

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.raulmacias.klima.Api.API_KEY
import com.example.raulmacias.klima.Api.DARK_SKY_URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val latitud = 37.8267
        val longitud = -122.4233



        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "$DARK_SKY_URL/$API_KEY/$latitud,$longitud"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                //textView.text = "Response is: ${response.substring(0, 500)}"
                Toast.makeText(this,response.substring(0,500) ,Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { Toast.makeText(this,"No Respuesta",Toast.LENGTH_SHORT).show()})

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}
