package com.example.appvacinfo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.appvacinfo.model.Vaccine
import com.example.appvacinfo.ui.CustomAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import java.io.IOException

class quandoVacinarAdultos : AppCompatActivity(){
private lateinit var listViewName: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quando_vacinar_adultos)

        val jsonFileString = getJsonDataFromAsset(this, "data/vaccines/adults.json");
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Vaccine>>() {}.type
        val vaccines: List<Vaccine> = gson.fromJson(jsonFileString, listPersonType)
        Log.i("VAC", vaccines.toString())

        try{
            val vaccines: List<Vaccine> = gson.fromJson(jsonFileString, listPersonType)

            listViewName = findViewById(R.id.name_quando_vacinar_adultos)
            listViewName.adapter = CustomAdapter(this, vaccines)


        }catch(e: JSONException){
            e.printStackTrace()
        }

    }
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }




}