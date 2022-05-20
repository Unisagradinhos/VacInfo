package com.example.appvacinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appvacinfo.controller.faqController.FaqActivity
import com.example.appvacinfo.controller.mitosController.MitosActivity
import com.example.appvacinfo.controller.ondeVacinar_controller.ondeVacinar
import com.example.appvacinfo.controller.sobreController.SobreActivity
import com.example.appvacinfo.controller.sobreController.quandoVacinarIdosos
import com.google.android.material.navigation.NavigationView

class quandoVacinar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_quando_vacinar)
        drawerConfig();

        val button_criancas = findViewById<Button>(R.id.btn_criancas)
        val button_adolescentes = findViewById<Button>(R.id.btn_adolescentes)
        val button_adultos = findViewById<Button>(R.id.btn_adultos)
        val button_gestantes = findViewById<Button>(R.id.btn_gestantes)
        val button_idosos = findViewById<Button>(R.id.btn_idosos)
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.faixa_etaria_criancas, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinner = findViewById<Spinner>(R.id.spinner_criancas)
        spinner.adapter = adapter

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
    private fun getValues(view: View) {
        val spinner = findViewById<Spinner>(R.id.spinner_criancas)
        val spinner2 = findViewById<Spinner>(R.id.spinner_criancas2)

        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_LONG).show()
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

    //DRAWER: -->
    private lateinit var toggle : ActionBarDrawerToggle
    private fun drawerConfig(){
        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    val tela_home = Intent(this, MainActivity::class.java)
                    startActivity(tela_home)
                }
                R.id.nav_calendar -> {
                    val tela_QuandoVacinar = Intent(this, quandoVacinar::class.java)
                    startActivity(tela_QuandoVacinar)
                }
                R.id.nav_location -> {
                    val tela_OndeVacinar = Intent (this, ondeVacinar::class.java)
                    startActivity(tela_OndeVacinar)
                }
                R.id.nav_vaccines->{
                    val tela_Vacinas = Intent (this, FaqActivity ::class.java)
                    startActivity(tela_Vacinas)
                }
                R.id.nav_diseases -> {
                    val tela_Doencas = Intent (this, MitosActivity ::class.java)
                    startActivity(tela_Doencas)
                }
                R.id.nav_about ->  {
                    val tela_Sobre = Intent (this, SobreActivity::class.java)
                    startActivity(tela_Sobre)
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    //<<-- DRAWER:
}