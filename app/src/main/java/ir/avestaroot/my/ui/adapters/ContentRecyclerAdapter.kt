package ir.avestaroot.my.ui.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.avestaroot.my.data.mediaStore.AudioHelper
import ir.avestaroot.my.data.mediaStore.MediaStoreHelper
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Audio
import ir.avestaroot.my.util.FragmentNavigator.Fragments.Videos
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.databinding.ItemContentBinding
import ir.avestaroot.my.util.FragmentNavigator
import ir.avestaroot.my.util.loadByGlide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentRecyclerAdapter(private val dataType: FragmentNavigator.Fragments) :
    ListAdapter<ContentItem, ContentRecyclerAdapter.ViewHolder>(
        AsyncDifferConfig.Builder(

            object : DiffUtil.ItemCallback<ContentItem>() {
                override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
                    return oldItem.id == newItem.id
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

        return ViewHolder(ItemContentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    inner class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val item = getItem(position)
            val context = binding.root.context

            binding.nameTv.text = item.title

            CoroutineScope(Dispatchers.IO).launch {
                val thumbnail = when (dataType) {
                    Audio -> AudioHelper.getAudioThumbnailByUri(
                        MediaStoreHelper(context.contentResolver).getUriFromId(item.id) ?: ""
                    )

                    //this branch will be never used
                    else -> null
                }

                withContext(Dispatchers.Main) {
                    if (dataType == Videos) {
                        binding.img.loadByGlide(MediaStoreHelper(binding.root.context.contentResolver).getUriFromId(item.id))
                    } else {

                        binding.img.setImageBitmap(thumbnail)

                    }
                }
            }
        }
    }
}