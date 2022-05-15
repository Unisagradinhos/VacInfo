package com.example.appvacinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toggle : ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        val button_quando_vacinar = findViewById<Button>(R.id.btn_quando_vacinar)
        val button_onde_vacinar = findViewById<Button>(R.id.btn_onde_vacinar)
        val button_vacinas = findViewById<Button>(R.id.btn_vacinas)
        val button_doencas = findViewById<Button>(R.id.btn_doencas)
        val button_sobre = findViewById<Button>(R.id.btn_sobre)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_location -> {

                }
                R.id.nav_calendar -> {

                }
            }
            true
        }

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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
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