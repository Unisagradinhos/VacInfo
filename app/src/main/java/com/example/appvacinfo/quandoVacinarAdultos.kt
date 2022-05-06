package com.example.appvacinfo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appvacinfo.model.Vaccine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class quandoVacinarAdultos : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quando_vacinar_adultos)

        val jsonFileString = getJsonDataFromAsset(this, "data/vaccines/adults.json");
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Vaccine>>() {}.type
        val vaccines: List<Vaccine> = gson.fromJson(jsonFileString, listPersonType)
        Log.i("VAC", vaccines.toString())

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