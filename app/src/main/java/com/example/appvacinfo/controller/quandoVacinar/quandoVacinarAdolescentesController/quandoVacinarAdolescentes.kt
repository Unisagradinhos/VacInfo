package com.example.appvacinfo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appvacinfo.controller.faqController.FaqActivity
import com.example.appvacinfo.controller.mitosController.MitosActivity
import com.example.appvacinfo.controller.ondeVacinar_controller.ondeVacinar
import com.example.appvacinfo.controller.sobreController.SobreActivity
import com.example.appvacinfo.model.carregarJson
import com.example.appvacinfo.ui.CustomAdapter
import com.google.android.material.navigation.NavigationView
import org.json.JSONException

class quandoVacinarAdolescentes : AppCompatActivity() {
    private lateinit var listViewName: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Adolescentes"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_quando_vacinar_list)
        val file: String = "data/vaccines/teenagers/at_12_years.json"
        try{
            val vacina = carregarJson(file, this)

            listViewName = findViewById(R.id.name_quando_vacinar_list)
            listViewName.adapter = CustomAdapter(this,vacina)


        }catch(e: JSONException){
            e.printStackTrace()
        }

    }
}