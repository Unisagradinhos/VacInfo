package com.example.appvacinfo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.appvacinfo.model.carregarJson
import com.example.appvacinfo.ui.CustomAdapter
import org.json.JSONException

class quandoVacinarCriancas : AppCompatActivity() {
    private lateinit var listViewName: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Crianças"

        //pega nome do arquivo a exibir:
        val b = intent.extras
        val fileName = b!!.getString("fileName")
        val file = fileName.toString()
        Log.i(TAG, "onCreate: aaaaaaaa"+  file)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_quando_vacinar_list)
        try{
            val vacina = carregarJson(file, this)

            listViewName = findViewById(R.id.name_quando_vacinar_list)
            listViewName.adapter = CustomAdapter(this,vacina)


        }catch(e: JSONException){
            e.printStackTrace()
        }

    }
}