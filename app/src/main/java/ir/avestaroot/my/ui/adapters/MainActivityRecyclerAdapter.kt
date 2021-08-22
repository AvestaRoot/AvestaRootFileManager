package ir.avestaroot.my.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.avestaroot.my.databinding.MainActivityMediaViewholderBinding
import ir.avestaroot.my.databinding.MainActivityStorageViewholderBinding
import ir.avestaroot.my.model.StorageItem
import ir.avestaroot.my.ui.fragments.MainFragment

class MainActivityRecyclerAdapter(
    private val list: List<Any>
) : RecyclerView.Adapter<MainActivityRecyclerAdapter.ViewHolder>() {

    private val MEDIA_VIEWHOLDER = 0
    private val STORAGE_VIEWHOLDER = 1

    private lateinit var onItemClickListener: OnItemClickListener

    open class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {}

    inner class MediaViewHolder(private val binding: MainActivityMediaViewholderBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = list[position] as MainFragment.Medias

            binding.iconImg.setBackgroundResource(item.iconRes)
            binding.titleTv.setText(item.nameRes)
        }
    }

    inner class StorageViewHolder(private val binding: MainActivityStorageViewholderBinding) :
        ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = list[position] as StorageItem

            binding.iconImg.setImageResource(item.iconRes)
            binding.statusTv.text = item.state
            binding.titleTv.text = item.title
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MEDIA_VIEWHOLDER -> MediaViewHolder(
                MainActivityMediaViewholderBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

//            STORAGE_VIEWHOLDER
            else -> StorageViewHolder(
                MainActivityStorageViewholderBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        when (item) {
            is MainFragment.Medias -> (holder as MediaViewHolder).bind(position)

            is StorageItem -> (holder as StorageViewHolder).bind(position)
        }

        holder.itemView.setOnClickListener {
            if (this::onItemClickListener.isInitialized)
                onItemClickListener.onRecyclerItemClicked(item is MainFragment.Medias, item)
        }

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return when (item) {
            is MainFragment.Medias -> MEDIA_VIEWHOLDER
            is StorageItem -> STORAGE_VIEWHOLDER

            //this branch will be never used
            else -> -1
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onRecyclerItemClicked(isMedia: Boolean, item: Any)
    }
}
