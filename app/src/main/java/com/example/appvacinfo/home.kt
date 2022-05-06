package com.example.appvacinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button_quando_vacinar = findViewById<Button>(R.id.btn_quando_vacinar)
        val button_onde_vacinar = findViewById<Button>(R.id.btn_onde_vacinar)
        val button_vacinas = findViewById<Button>(R.id.btn_vacinas)
        val button_doencas = findViewById<Button>(R.id.btn_doencas)
        val button_sobre = findViewById<Button>(R.id.btn_sobre)

        button_quando_vacinar.setOnClickListener {
            quando_vacinar();
        }
        button_onde_vacinar.setOnClickListener{
            onde_vacinar();
        }
        button_vacinas.setOnClickListener{
            vacinas();
        }
        button_doencas.setOnClickListener{
            doencas();
        }
        button_sobre.setOnClickListener{
            sobre();
        }
    }

    private fun quando_vacinar() {
        val tela_QuandoVacinar = Intent(this, quandoVacinar::class.java)
        startActivity(tela_QuandoVacinar)
    }
    private fun onde_vacinar(){
        val tela_OndeVacinar = Intent (this, ondeVacinar::class.java)
        startActivity(tela_OndeVacinar)
    }
    private fun vacinas(){
        val tela_Vacinas = Intent (this, vacinas::class.java)
        startActivity(tela_Vacinas)
    }
    private fun doencas(){
        val tela_Doencas = Intent (this, doencas::class.java)
        startActivity(tela_Doencas)
    }
    private fun sobre(){
        val tela_Sobre = Intent (this, sobre::class.java)
        startActivity(tela_Sobre)
    }
}