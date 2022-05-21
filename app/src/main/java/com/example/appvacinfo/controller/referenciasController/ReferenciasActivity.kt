package com.example.appvacinfo.controller.referenciasController

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appvacinfo.R
import com.example.appvacinfo.model.carregarJsonReference
import com.example.appvacinfo.ui.CustomAdapterReference
import org.json.JSONException


class ReferenciasActivity : AppCompatActivity() {
    private lateinit var listViewName: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Referências"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencias)
                val file: String = "data/references/references.json"

        try{
            val references = carregarJsonReference(file, this)

            listViewName = findViewById(R.id.reference_list)
            listViewName.adapter = CustomAdapterReference(this, references )


        }catch(e: JSONException){
            e.printStackTrace()
        }



    }

}