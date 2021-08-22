package ir.avestaroot.my.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.databinding.ItemStorageBinding

class ContentRecyclerAdapter() :
    ListAdapter<ContentItem, ContentRecyclerAdapter.ViewHolder>(
        AsyncDifferConfig.Builder(

            object : DiffUtil.ItemCallback<ContentItem>() {
                override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: ContentItem,
                    newItem: ContentItem
                ): Boolean {
                    return oldItem.equals(newItem)
                }
            }

        ).build()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(ItemStorageBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    inner class ViewHolder(private val binding: ItemStorageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val item = getItem(position)

            Log.d("myapplog", "bind")

            binding.nameTv.text = item.title
            /*binding.itemsCountTv.text = item.itemsCount
            binding.dateTv.text = item.dateAdded

            Glide.with(itemView.context)
                .load(item.data)
                .into(binding.img)*/
        }
    }
}