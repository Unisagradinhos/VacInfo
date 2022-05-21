package com.example.appvacinfo.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.appvacinfo.R
import com.example.appvacinfo.model.Reference

class CustomAdapterReference(var context: Context, var references: List<Reference>) : BaseAdapter() {
    override fun getCount(): Int {
        return references.size
    }

    override fun getItem(position: Int): Any {
        return references[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
        val createdView = LayoutInflater
            .from(context)
            .inflate(R.layout.card_sobre, viewGroup, false)

        val name: TextView = createdView.findViewById(R.id.name)
        name.text = references[position].name

//        val initials: TextView = createdView.findViewById(R.id.initials)
//        initials.text = references[position].initials

        val link: TextView = createdView.findViewById(R.id.link)
        link.text = references[position].link

        return createdView
    }

}