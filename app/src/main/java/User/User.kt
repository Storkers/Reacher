@file:Suppress("DEPRECATION")

package com.example.reacherj

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.content.Intent
import android.app.Activity
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class User : AppCompatActivity()
{
        private lateinit var imageViewBackground: ImageView
        private lateinit var imageViewProfile: ImageView
        private lateinit var buttonChangeBackground: Button
        private lateinit var buttonChangeProfile: Button

        private val PICK_IMAGE_PROFILE = 101
        private val PICK_IMAGE_BACKGROUND = 102
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.user)

            val buttonBack = findViewById<Button>(R.id.buttonUserBack)
            buttonBack.setOnClickListener {
                finish() // Chama o método padrão de voltar
            }

            val seleta = findViewById<LinearLayout>(R.id.Conta)
            seleta.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }

            val configura = findViewById<LinearLayout>(R.id.Configuracoes)
            configura.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }

            val notifica = findViewById<LinearLayout>(R.id.Notificacao)
            notifica.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }

            val pagamento = findViewById<LinearLayout>(R.id.Pagamentos)
            pagamento.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }

            val historico = findViewById<LinearLayout>(R.id.Historico)
            historico.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }

            val documento = findViewById<LinearLayout>(R.id.Documentos)
            documento.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent) }
        }


}