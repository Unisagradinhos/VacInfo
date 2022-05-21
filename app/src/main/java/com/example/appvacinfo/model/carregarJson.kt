package com.example.appvacinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

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
fun carregarJson( filename: String, context: Context): List<Vaccine> {
    val jsonFileString = getJsonDataFromAsset(context, filename);
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Vaccine>>() {}.type
    val vaccines: List<Vaccine> = gson.fromJson(jsonFileString, listPersonType)
    return vaccines
}

fun carregarJsonMito( filename: String, context: Context): List<Myths> {
    val jsonFileString = getJsonDataFromAsset(context, filename);
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Myths>>() {}.type
    val myths: List<Myths> = gson.fromJson(jsonFileString, listPersonType)
    return myths
}

fun carregarJsonReference( filename: String, context: Context): List<Reference> {
    val jsonFileString = getJsonDataFromAsset(context, filename);
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Reference>>() {}.type
    val references: List<Reference> = gson.fromJson(jsonFileString, listPersonType)
    return references
}

