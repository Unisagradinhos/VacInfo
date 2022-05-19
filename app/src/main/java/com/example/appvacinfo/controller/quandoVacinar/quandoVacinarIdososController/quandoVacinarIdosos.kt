package com.example.appvacinfo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appvacinfo.controller.ondeVacinar_controller.ondeVacinar
import com.example.appvacinfo.model.carregarJson
import com.example.appvacinfo.ui.CustomAdapter
import com.google.android.material.navigation.NavigationView
import org.json.JSONException

class quandoVacinarIdosos : AppCompatActivity() {
    private lateinit var listViewName: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_quando_vacinar_list)
        drawerConfig();

        val file: String = "data/vaccines/seniors.json"

        try{
            val vacina = carregarJson(file, this)

            listViewName = findViewById(R.id.name_quando_vacinar_list)
            listViewName.adapter = CustomAdapter(this,vacina)


        }catch(e: JSONException){
            e.printStackTrace()
        }

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
                    val tela_Vacinas = Intent (this, vacinas::class.java)
                    startActivity(tela_Vacinas)
                }
                R.id.nav_diseases -> {
                    val tela_Doencas = Intent (this, doencas::class.java)
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