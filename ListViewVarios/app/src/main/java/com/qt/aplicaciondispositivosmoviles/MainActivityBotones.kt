package com.qt.aplicaciondispositivosmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qt.aplicaciondispositivosmoviles.databinding.ActivityMainBotonesBinding


class MainActivityBotones : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBotonesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBotonesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonPersonas.setOnClickListener(this)
        binding.buttonAutomoviles.setOnClickListener(this)

    }

    override fun onClick(botonCliqueado: View?) {
        if (botonCliqueado?.id == R.id.buttonAutomoviles){
            val intent : Intent = Intent(this, MainActivityAutomoviles::class.java)
            startActivity(intent)
        }

        else if (botonCliqueado?.id == R.id.buttonPersonas){
            val intent : Intent = Intent(this, MainActivityPersonas::class.java)
            startActivity(intent)
        }
    }
}