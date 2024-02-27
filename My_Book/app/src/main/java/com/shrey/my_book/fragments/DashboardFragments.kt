package com.shrey.my_book.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shrey.my_book.R
import com.shrey.my_book.adapter.MyAdapter

class DashboardFragments : Fragment() {


    val songs = listOf<String>("Alpha", "Beta", "Gama", "Hotel", "Seria", "Omega","Alpha", "Beta", "Gama", "Hotel", "Seria", "Omega","Alpha", "Beta", "Gama", "Hotel", "Seria", "Omega","Alpha", "Beta", "Gama", "Hotel", "Seria", "Omega")

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragments_dashboard_layout, container, false)
//        recycleDashboard = view.findViewById(R.id.recyclerDashboard)
//        layoutManager = LinearLayoutManager(activity)
          val recycle: RecyclerView = view.findViewById(R.id.recyclerDashboard)
          recycle.adapter =MyAdapter(songs)
        recycle.layoutManager = LinearLayoutManager(activity)
        return view
    }
}
