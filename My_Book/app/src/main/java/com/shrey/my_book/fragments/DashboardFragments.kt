package com.shrey.my_book.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shrey.my_book.R
import com.shrey.my_book.adapter.MyAdapter
import com.shrey.my_book.model.Book

class DashboardFragments : Fragment() {


    val songs = listOf<String>(
        "P.S . I Love You",
        "The Great Gatsby",
        "Anna Karenina",
        "Madam Bovary",
        "War And Peace",
        "Lolita",
        "Middlemarch",
        "The Adventures",
        "Mody-Dick",
        "The Lord Of The Rings"
    )

    val bookInfoList = arrayListOf<Book>(
        Book("P.S. I Love You", "Cecelia Aherin", "Rs. 249", "4.5", R.drawable.ps_ily),
        Book("The Great Gatsby", "F Scott Fitzgerald", "Rs. 399", "4.1",R.drawable.great_gatsby),
        Book("Anna Karenina", "Leo Tolstoy", "Rs. 199", "4.9", R.drawable.anna_kare),
        Book("Madam Bovary", "Gustava Flaubert", "Rs. 349", "3.9", R.drawable.madame),
        Book("War and Peace", "Leo Tolstoy", "Rs. 249", "4.8",R.drawable.war_and_peace),
        Book("Lolita", "Vladimir Nabokov", "Rs. 500", "4.0", R.drawable.lolita),
        Book("Middlemarch", "George Elliot", "Rs. 599", "4.2", R.drawable.middlemarch),
        Book("Moby-Dick", "Herman Melville", "Rs. 499", "4.5", R.drawable.moby_dick),
        Book("The Lord Of The Rings", "J.R.R. Tolkien", "Rs. 749", "5.0", R.drawable.lord_of_rings)
    )




    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragments_dashboard_layout, container, false)
//        recycleDashboard = view.findViewById(R.id.recyclerDashboard)
//        layoutManager = LinearLayoutManager(activity)
        val recycle: RecyclerView = view.findViewById(R.id.recyclerDashboard)
        recycle.adapter = MyAdapter(bookInfoList)
        recycle.layoutManager = LinearLayoutManager(activity)
        recycle.addItemDecoration(
            DividerItemDecoration(
                recycle.context, LinearLayoutManager(activity).orientation
            )
        )


        return view
    }
}
