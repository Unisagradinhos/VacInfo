package com.example.appvacinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun carregarJson( filename: String, context: Context): List<Vaccine> {
    val jsonFileString = getJsonDataFromAsset(context, filename);
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Vaccine>>() {}.type
    val vaccines: List<Vaccine> = gson.fromJson(jsonFileString, listPersonType)
    return vaccines
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