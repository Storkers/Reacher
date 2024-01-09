package com.example.reacherj


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.MediaController
import android.net.Uri
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        //val videoView = findViewById<VideoView>(R.id.videoView)

        // Caminho do vídeo MP4 dentro da pasta 'res/raw'
       // val videoPath = "android.resource://" + packageName + "/" + R.raw.fundo_animado
       // val uri = Uri.parse(videoPath)

        //val videoUri = Uri.parse(videoPath)
       // videoView.setVideoURI(videoUri)

        //val mediaController = MediaController(this)
        //mediaController.setAnchorView(videoView)
        //videoView.setMediaController(mediaController)

        //videoView.setVideoURI(uri)
        //videoView.start()

        val buttonLogin = findViewById<TextView>(R.id.loginButton)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        val buttonHome = findViewById<Button>(R.id.button1)
        buttonHome.setOnClickListener {
            val intent1 = Intent(this, Home::class.java)
            startActivity(intent1)
        }
    }
}