package com.example.appvacinfo.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.appvacinfo.R
import com.example.appvacinfo.model.Myths
import com.example.appvacinfo.model.Vaccine

class CustomAdapterMitos(var context: Context, var myths: List<Myths>) : BaseAdapter() {
    override fun getCount(): Int {
        return myths.size
    }

    override fun getItem(position: Int): Any {
        return myths[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
        val createdView = LayoutInflater
            .from(context)
            .inflate(R.layout.card_mitos, viewGroup, false)

        val mythsName: TextView = createdView.findViewById(R.id.title)
        mythsName.text = myths[position].title

        val mythsLabel: TextView = createdView.findViewById(R.id.is_mith)
        mythsLabel.text = myths[position].label

        val mythsExplanation: TextView = createdView.findViewById(R.id.explanation)
        mythsExplanation.text = myths[position].explanation


        return createdView
    }

}