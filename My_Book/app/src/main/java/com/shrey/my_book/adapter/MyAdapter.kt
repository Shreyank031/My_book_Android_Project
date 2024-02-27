package com.shrey.my_book.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shrey.my_book.R

class MyAdapter(val songs: List<String>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val infaltor = LayoutInflater.from(parent.context)
        val view = infaltor.inflate(R.layout.recycler_dashboard_single_row_for_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = songs[position]
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView = itemView.findViewById(R.id.txtRecyclerRowItem)

}

