package ir.avestaroot.my

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ir.avestaroot.my.databinding.ActivityMainStorageItemLayoutBinding

class ActivityMainStorageItemLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0

) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy { ActivityMainStorageItemLayoutBinding.inflate(LayoutInflater.from(context, this, true)) }

    init {
        context.obtainStyledAttributes()
    }
}