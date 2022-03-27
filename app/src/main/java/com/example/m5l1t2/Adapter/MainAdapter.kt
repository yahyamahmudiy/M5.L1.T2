package com.example.m5l1t2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l1t2.Model.Page
import com.example.m5l1t2.R

class MainAdapter(var pages: ArrayList<Page>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
        return view
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val (image, context, description) = pages[position]
        if (holder is ViewHolder) {
            holder.iv_opener.setImageResource(image)
            holder.tv_context.text = context
            holder.tv_description.text = description
        }
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_opener: ImageView = itemView.findViewById(R.id.iv_opener)
        var tv_context: TextView = itemView.findViewById(R.id.tv_context)
        var tv_description: TextView = itemView.findViewById(R.id.tv_description)
    }