package com.example.reacherj

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class Mapa : AppCompatActivity(), OnMapReadyCallback {


    lateinit var mMap: GoogleMap



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maps)

        val buttonBack = findViewById<Button>(R.id.buttonLoginBack)
        buttonBack.setOnClickListener {
            finish() // Chama o método padrão de voltar
        }

        val url = "https://json-server-six-bay.vercel.app/parana" // URL do servidor JSON


        val client = OkHttpClient() //Teste Cliente

        //Conexao request
        val btnTodos = findViewById<Button>(R.id.textItem1)
        val btnPordoSol = findViewById<Button>(R.id.textItem2)
        val btnCaminhada = findViewById<Button>(R.id.textItem3)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)


        val request = Request.Builder()
            .url(url)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Trata falha na requisição
                e.printStackTrace()
            }


            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body?.string() // Obtém os dados da resposta


                // Processa os dados recebidos
                responseData?.let {
                    try {
                        val jsonArray = JSONArray(it)


                        // Itera sobre os dados para adicionar marcadores para cada coordenada
                        for (i in 0 until jsonArray.length()) {
                            val jsonObject = jsonArray.getJSONObject(i)
                            val latitude = jsonObject.getDouble("latitude")
                            val longitude = jsonObject.getDouble("longitude")


                            // Cria um objeto LatLng para o marcador
                            val location = LatLng(latitude, longitude)


                            // Adiciona um marcador no mapa para cada coordenada
                            runOnUiThread {
                                mMap.addMarker(
                                    MarkerOptions().position(location).title("Marcador $i")
                                )
                            }
                        }

                        // Listener para o botão "Todos"
                        btnTodos.setOnClickListener {
                            // Limpa todos os marcadores do mapa antes de adicionar os marcadores da categoria "caminhada"
                            mMap.clear()

                            // Itera sobre os dados para adicionar marcadores para cada coordenada
                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val latitude = jsonObject.getDouble("latitude")
                                val longitude = jsonObject.getDouble("longitude")


                                // Cria um objeto LatLng para o marcador
                                val location = LatLng(latitude, longitude)


                                // Adiciona um marcador no mapa para cada coordenada
                                runOnUiThread {
                                    mMap.addMarker(
                                        MarkerOptions().position(location).title("Marcador $i")
                                    )
                                }
                            }
                        }

                        // Listener para o botão "Por do Sol"
                        btnPordoSol.setOnClickListener {
                            // Limpa todos os marcadores do mapa antes de adicionar os marcadores da categoria "caminhada"
                            mMap.clear()

                            // Itera sobre os dados para adicionar marcadores apenas para a categoria "caminhada"
                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val categoria = jsonObject.getString("categoria")

                                // Verifica se a categoria é "caminhada"
                                if (categoria.equals("pordosol", ignoreCase = true)) {
                                    val latitude = jsonObject.getDouble("latitude")
                                    val longitude = jsonObject.getDouble("longitude")

                                    // Cria um objeto LatLng para o marcador
                                    val location = LatLng(latitude, longitude)

                                    // Adiciona um marcador no mapa para cada coordenada da categoria "caminhada"
                                    runOnUiThread {
                                        mMap.addMarker(
                                            MarkerOptions().position(location).title("Marcador $i - PordoSol")
                                        )
                                    }
                                }
                            }
                        }

                        // Listener para o botão "Caminhada"
                        btnCaminhada.setOnClickListener {
                            // Limpa todos os marcadores do mapa antes de adicionar os marcadores da categoria "caminhada"
                            mMap.clear()

                            // Itera sobre os dados para adicionar marcadores apenas para a categoria "caminhada"
                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val categoria = jsonObject.getString("categoria")

                                // Verifica se a categoria é "caminhada"
                                if (categoria.equals("caminhada", ignoreCase = true)) {
                                    val latitude = jsonObject.getDouble("latitude")
                                    val longitude = jsonObject.getDouble("longitude")

                                    // Cria um objeto LatLng para o marcador
                                    val location = LatLng(latitude, longitude)

                                    // Adiciona um marcador no mapa para cada coordenada da categoria "caminhada"
                                    runOnUiThread {
                                        mMap.addMarker(
                                            MarkerOptions().position(location).title("Marcador $i - Caminhada")
                                        )
                                    }
                                }
                            }
                        }

                        // Centraliza o mapa na última coordenada
                        val lastObject = jsonArray.getJSONObject(jsonArray.length() - 1)
                        val lastLatitude = lastObject.getDouble("latitude")
                        val lastLongitude = lastObject.getDouble("longitude")
                        val lastLocation = LatLng(lastLatitude, lastLongitude)
                        runOnUiThread {
                            mMap.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(
                                    lastLocation,
                                    10f
                                )
                            ) // Zoom 10
                        }


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }
}
