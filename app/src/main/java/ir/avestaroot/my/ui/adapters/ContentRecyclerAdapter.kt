package ir.avestaroot.my.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.avestaroot.my.model.ContentItem
import ir.avestaroot.my.databinding.ItemStorageBinding

class ContentRecyclerAdapter(private val mList: List<Long>) :
    RecyclerView.Adapter<ContentRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(ItemStorageBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]


        //bind data here

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun getItemCount() = mList.size

    class ViewHolder(binding: ItemStorageBinding) : RecyclerView.ViewHolder(binding.root) {
        val nameTv = binding.nameTv
        val dateTv = binding.dateTv
        val itemsCountTv = binding.itemsCountTv
    }
}