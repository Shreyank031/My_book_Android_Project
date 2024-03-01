package com.shrey.my_book.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.shrey.my_book.R
import com.shrey.my_book.model.Book

class MyAdapter(val context: Context,val itemList: ArrayList<Book>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val infaltor = LayoutInflater.from(parent.context)
        val view = infaltor.inflate(R.layout.recycler_dashboard_single_row_for_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       // holder.txtTitle.text = songs[position]
        holder.txtBookName.text = itemList[position].bookName
        holder.txtBookAuthor.text = itemList[position].bookAuthor
        holder.txtBookRatings.text = itemList[position].bookRatings
        holder.txtBookPrice.text = itemList[position].bookCost
        holder.imgBookImage.setImageResource(itemList[position].bookImage)
        holder.RelativeLayout.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.txtBookName.text}", Toast.LENGTH_SHORT).show()
            //Toast.makeText(holder.itemView.context, "Clicked on ${holder.txtBookName.text}", Toast.LENGTH_SHORT).show()
        }
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //var txtTitle: TextView = itemView.findViewById(R.id.txtRecyclerRowItem)
    var txtBookName: TextView = itemView.findViewById(R.id.txtBookName)
    var txtBookAuthor: TextView = itemView.findViewById(R.id.txtNameOfAuthor)
    var txtBookRatings: TextView = itemView.findViewById(R.id.txtBookRating)
    var txtBookPrice: TextView = itemView.findViewById(R.id.txtBookPrice)
    var imgBookImage: ImageView = itemView.findViewById(R.id.imgAndy)
    var RelativeLayout: RelativeLayout = itemView.findViewById(R.id.RelLayout)

}

