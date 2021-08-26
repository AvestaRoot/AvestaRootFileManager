package ir.avestaroot.my.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.ContentFragmentTopBarRecyclerViewholderBinding
import ir.avestaroot.my.databinding.ContentFragmentTopbarBinding

class ContentFragmentTopBar @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy {
        ContentFragmentTopbarBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    var icon: Int? = null
        set(value) {
            field = value

            value?.let { binding.iconImg.setImageResource(it) }
        }

    private val adapter by lazy { ContentFragmentTopBarRecyclerAdapter(titles) }

    var titles = mutableListOf<String>()

    fun addTitle(title: String) {
        titles.add(title)
        adapter.notifyItemInserted(titles.size - 1)
    }
    fun back() {
        titles.removeAt(titles.size - 1)
        adapter.notifyItemRemoved(titles.size - 1)
    }

    var count: String = ""
        set(value) {
            field = value

            binding.sizeTv.text = value
        }

    init {
        setValues()
    }

    private fun setValues() {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle, 0)

        binding.iconImg.setImageResource(attributes.getResourceId(R.styleable.CustomView_icon, -1))
        binding.sizeTv.text = attributes.getString(R.styleable.CustomView_size)
        binding.titlesRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.titlesRecycler.adapter = adapter
    }
}


class ContentFragmentTopBarRecyclerAdapter(private val list: MutableList<String>) : RecyclerView.Adapter<ContentFragmentTopBarRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ContentFragmentTopBarRecyclerViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val title = list[position]

            binding.titleTv.text = title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentFragmentTopBarRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ContentFragmentTopBarRecyclerViewholderBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(
        holder: ContentFragmentTopBarRecyclerAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(position)

        holder.itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun getItemCount() = list.size
}