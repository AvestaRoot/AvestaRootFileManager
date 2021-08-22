package ir.avestaroot.my.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.BackbuttonSearchviewLayoutBinding

class BackButtonSearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy { BackbuttonSearchviewLayoutBinding.inflate(LayoutInflater.from(context), this, true) }
    private lateinit var backButtonClickListener: BackButtonClickListener

    init {
        binding.toolbar.setOnClickListener {
            when(it.id) {
                R.id.toolbar -> {
                    if (this::backButtonClickListener.isInitialized)
                        this.backButtonClickListener.onBackButtonClicked()
                }
            }

            true
        }
    }

    fun interface BackButtonClickListener {
        fun onBackButtonClicked()
    }

    fun setOnBackButtonClickListener(backButtonClickListener: BackButtonClickListener) {
        this.backButtonClickListener = backButtonClickListener
    }

}