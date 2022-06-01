package com.example.appvacinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appvacinfo.controller.faqController.FaqActivity
import com.example.appvacinfo.controller.mitosController.MitosActivity
import com.example.appvacinfo.controller.ondeVacinar_controller.ondeVacinar
import com.example.appvacinfo.controller.sobreController.SobreActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "VacInfo"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        drawerConfig();

        val button_quando_vacinar = findViewById<ImageButton>(R.id.btn_quando_vacinar)
        val button_onde_vacinar = findViewById<ImageButton>(R.id.btn_onde_vacinar)
        val button_vacinas = findViewById<ImageButton>(R.id.btn_vacinas)
        val button_doencas = findViewById<ImageButton>(R.id.btn_doencas)
        val button_sobre = findViewById<ImageButton>(R.id.btn_sobre)


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
        val tela_Vacinas = Intent (this, FaqActivity::class.java)
        startActivity(tela_Vacinas)
    }
    private fun doencas(){
        val tela_Doencas = Intent (this, MitosActivity::class.java)
        startActivity(tela_Doencas)
    }
    private fun sobre(){
        val tela_Sobre = Intent (this, SobreActivity::class.java)
        startActivity(tela_Sobre)
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
                    val tela_Vacinas = Intent (this, FaqActivity::class.java)
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