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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class User : AppCompatActivity()
{
        private lateinit var imageViewBackground: ImageView
        private lateinit var imageViewProfile: ImageView
        private lateinit var buttonChangeBackground: Button
        private lateinit var buttonChangeProfile: Button

        private val PICK_IMAGE = 100
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.user)

            val buttonBack = findViewById<Button>(R.id.buttonUserBack)
            buttonBack.setOnClickListener {
                finish() // Chama o método padrão de voltar
            }

            imageViewProfile = findViewById<ImageView>(R.id.imageView5)
            imageViewBackground = findViewById<ImageView>(R.id.imageView2)

            // Definindo um clique na imagem de perfil para abrir a galeria
            imageViewProfile.setOnClickListener {
                openGalleryForProfile()
            }

            // Definindo um clique na imagem de fundo para abrir a galeria
            imageViewBackground.setOnClickListener {
                openGalleryForBackground()
            }
        }

    // Método para abrir a galeria para selecionar uma imagem de perfil
    private fun openGalleryForProfile() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    // Método para abrir a galeria para selecionar uma imagem de fundo
    private fun openGalleryForBackground() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    // Método chamado após selecionar a imagem na galeria
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri = data?.data
            // Atualizar as imagens de perfil e de fundo com a imagem selecionada
            imageUri?.let {
                if (requestCode == PICK_IMAGE) {
                    // Atualizar a imagem de perfil
                    imageViewProfile.setImageURI(imageUri)
                } else {
                    // Atualizar a imagem de fundo
                    imageViewBackground.setImageURI(imageUri)
                }
            }
        }
    }

}