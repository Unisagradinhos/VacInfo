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
    private var clicked_criancas = false
    private var clicked_adolescentes = false
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Quando Vacinar"
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
        val btn_at_2_months = findViewById<Button>(R.id.at_2_months)
        val btn_at_3_months = findViewById<Button>(R.id.at_3_months)
        val btn_at_6_months = findViewById<Button>(R.id.at_6_months)
        val btn_at_9_months = findViewById<Button>(R.id.at_9_months)
        val btn_at_12_months = findViewById<Button>(R.id.at_12_months)
        val btn_at_15_months = findViewById<Button>(R.id.at_15_months)
        val btn_at_4_years = findViewById<Button>(R.id.at_4_years)
        val btn_at_5_years = findViewById<Button>(R.id.at_5_years)
        val btn_at_9_years = findViewById<Button>(R.id.at_9_years)
        val btn_at_12_years = findViewById<Button>(R.id.at_12_years)
        val btn_between_12_and_19 = findViewById<Button>(R.id.between_12_and_19)


        button_criancas.setOnClickListener {
            clicked_criancas = !clicked_criancas
            quando_vacinar_criancas(clicked_criancas, btn_at_2_months,btn_at_3_months,btn_at_6_months,btn_at_9_months,btn_at_12_months,btn_at_15_months
            ,btn_at_4_years,btn_at_5_years,btn_at_9_years);
        }
        button_adolescentes.setOnClickListener {
            clicked_adolescentes = !clicked_adolescentes
            quando_vacinar_adolescentes(clicked_adolescentes, btn_at_12_years, btn_between_12_and_19);
        }
        btn_at_12_years.setOnClickListener{
            quandoVacinarAdolescentesAction("data/vaccines/teenagers/at_12_years.json")
        }
        btn_between_12_and_19.setOnClickListener{
            quandoVacinarAdolescentesAction("data/vaccines/teenagers/between_12_and_19_years.json")
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

    private fun quando_vacinar_criancas(clicked: Boolean,btn_at_2_months : Button,btn_at_3_months : Button,btn_at_6_months : Button,btn_at_9_months : Button,btn_at_12_months : Button,btn_at_15_months : Button
                                        ,btn_at_4_years : Button,btn_at_5_years : Button,btn_at_9_years : Button) {
        setVisibility_criancas(clicked, btn_at_2_months,btn_at_3_months,btn_at_6_months,btn_at_9_months,btn_at_12_months,btn_at_15_months
            ,btn_at_4_years,btn_at_5_years,btn_at_9_years)
//        val tela_QuandoVacinarCriancas = Intent(this, quandoVacinarCriancas::class.java)
//        startActivity(tela_QuandoVacinarCriancas)
    }
    private fun quando_vacinar_adolescentes(clicked: Boolean,btn_at_12_years : Button,btn_between_12_and_19 : Button) {
        setVisibility_adolescentes(clicked,btn_at_12_years,btn_between_12_and_19)
        val tela_QuandoVacinarAdolescentes = Intent(this, quandoVacinarAdolescentes::class.java)

    }
    private fun quandoVacinarAdolescentesAction(fileName : String) {
        val tela_QuandoVacinarAdolescentes = Intent(this, quandoVacinarAdolescentes::class.java)
        tela_QuandoVacinarAdolescentes.putExtra("fileName", fileName)
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

    private fun setVisibility_criancas(clicked: Boolean,btn_at_2_months : Button,btn_at_3_months : Button,btn_at_6_months : Button,btn_at_9_months : Button,btn_at_12_months : Button,btn_at_15_months : Button
                              ,btn_at_4_years : Button,btn_at_5_years : Button,btn_at_9_years : Button) {
        if(clicked){
            btn_at_2_months.visibility = View.VISIBLE
            btn_at_3_months.visibility = View.VISIBLE
            btn_at_6_months.visibility = View.VISIBLE
            btn_at_9_months.visibility = View.VISIBLE
            btn_at_12_months.visibility = View.VISIBLE
            btn_at_15_months.visibility = View.VISIBLE
            btn_at_4_years.visibility = View.VISIBLE
            btn_at_5_years.visibility = View.VISIBLE
            btn_at_9_years.visibility = View.VISIBLE
        }
        else{
            btn_at_2_months.visibility = View.GONE
            btn_at_3_months.visibility = View.GONE
            btn_at_6_months.visibility = View.GONE
            btn_at_9_months.visibility = View.GONE
            btn_at_12_months.visibility = View.GONE
            btn_at_15_months.visibility = View.GONE
            btn_at_4_years.visibility = View.GONE
            btn_at_5_years.visibility = View.GONE
            btn_at_9_years.visibility = View.GONE
        }
    }
    private fun setVisibility_adolescentes(clicked: Boolean,btn_at_12_years : Button,btn_between_12_and_19 : Button) {
        if(clicked){
            btn_at_12_years.visibility = View.VISIBLE
            btn_between_12_and_19.visibility = View.VISIBLE
        }
        else{
            btn_at_12_years.visibility = View.GONE
            btn_between_12_and_19.visibility = View.GONE
        }
    }
}