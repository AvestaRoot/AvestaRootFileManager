package ir.avestaroot.my

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ir.avestaroot.my.databinding.ContentFragmentTopBarBinding

class CustomView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy {
        ContentFragmentTopBarBinding.inflate(
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

    var title: String = ""
        set(value) {
            field = value

            binding.titleTv.text = value
        }

    var size: String = ""
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
        binding.titleTv.text = attributes.getString(R.styleable.CustomView_title)
        binding.sizeTv.text = attributes.getString(R.styleable.CustomView_size)
    }
}