package com.example.betanalyzier

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Redirigir a la Activity en el paquete ui.main
        startActivity(Intent(this, com.example.betanalyzier.ui.main.MainActivity::class.java))
        finish()
    }
}