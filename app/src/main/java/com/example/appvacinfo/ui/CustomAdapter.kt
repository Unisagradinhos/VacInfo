package com.example.appvacinfo.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.appvacinfo.R
import com.example.appvacinfo.model.Vaccine

class CustomAdapter(var context: Context, var vaccines: List<Vaccine>) : BaseAdapter() {
    override fun getCount(): Int {
        return vaccines.size
    }

    override fun getItem(position: Int): Any {
        return vaccines[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
        val createdView = LayoutInflater
            .from(context)
            .inflate(R.layout.vacinas, viewGroup, false)

        val vaccineName: TextView = createdView.findViewById(R.id.vacinas)
        vaccineName.text = vaccines[position].name

        val vaccineDoses: TextView = createdView.findViewById(R.id.doses)
        vaccineDoses.text = vaccines[position].doses

        val vaccineDiseasesAvoided: TextView = createdView.findViewById(R.id.diseases_avoided)
        vaccineDiseasesAvoided.text = vaccines[position].diseases_avoided

        return createdView
    }

}