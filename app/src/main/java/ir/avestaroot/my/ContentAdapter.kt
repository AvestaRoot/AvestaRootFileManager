package ir.avestaroot.my

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContentAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {


    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_storage, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.name_fl_tv.text = ItemsViewModel.name_fl_tv
        holder.date_fl_tv.text = ItemsViewModel.date_fl_tv
        holder.tv_items.text = ItemsViewModel.tv_items

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name_fl_tv: TextView = itemView.findViewById(R.id.name_fl_tv)
        val date_fl_tv: TextView = itemView.findViewById(R.id.date_fl_tv)
        val tv_items: TextView = itemView.findViewById(R.id.tv_items)
    }
}