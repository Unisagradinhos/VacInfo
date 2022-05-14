package com.example.appvacinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quandoVacinar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quando_vacinar)

        val button_criancas = findViewById<Button>(R.id.btn_criancas)
        val button_adolescentes = findViewById<Button>(R.id.btn_adolescentes)
        val button_adultos = findViewById<Button>(R.id.btn_adultos)
        val button_gestantes = findViewById<Button>(R.id.btn_gestantes)
        val button_idosos = findViewById<Button>(R.id.btn_idosos)

        button_criancas.setOnClickListener {
            quando_vacinar_criancas();
        }
        button_adolescentes.setOnClickListener {
            quando_vacinar_adolescentes();
        }
        button_adultos.setOnClickListener {
            quando_vacinar_adultos();
        }
        button_gestantes.setOnClickListener {
            quando_vacinar_gestantes();
        }
        button_idosos.setOnClickListener {
            quando_vacinar_idosos();
        }
    }
    private fun quando_vacinar_criancas() {
        val tela_QuandoVacinarCriancas = Intent(this, quandoVacinarCriancas::class.java)
        startActivity(tela_QuandoVacinarCriancas)
    }
    private fun quando_vacinar_adolescentes() {
        val tela_QuandoVacinarAdolescentes = Intent(this, quandoVacinarAdolescentes::class.java)
        startActivity(tela_QuandoVacinarAdolescentes)
    }
    private fun quando_vacinar_adultos() {
        val tela_QuandoVacinarAdultos = Intent(this, quandoVacinarAdultos::class.java)
        startActivity(tela_QuandoVacinarAdultos)
    }
    private fun quando_vacinar_gestantes() {
        val tela_QuandoVacinarGestantes = Intent(this, quandoVacinarGestantes::class.java)
        startActivity(tela_QuandoVacinarGestantes)
    }
    private fun quando_vacinar_idosos() {
        val tela_QuandoVacinarIdosos = Intent(this, quandoVacinarIdosos::class.java)
        startActivity(tela_QuandoVacinarIdosos)
    }
}