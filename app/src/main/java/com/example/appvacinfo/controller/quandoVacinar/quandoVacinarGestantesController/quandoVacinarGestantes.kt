package com.example.appvacinfo

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.appvacinfo.model.carregarJson
import com.example.appvacinfo.ui.CustomAdapter
import org.json.JSONException

class quandoVacinarGestantes : AppCompatActivity() {
    private lateinit var listViewName: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Gestantes"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quando_vacinar_list)
        val file: String = "data/vaccines/pregnant_women.json"

        try {
            val vacina = carregarJson(file, this)

            listViewName = findViewById(R.id.name_quando_vacinar_list)
            listViewName.adapter = CustomAdapter(this, vacina)


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
}