package ir.avestaroot.my.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.BackbuttonSearchviewLayoutBinding
import ir.avestaroot.my.databinding.MainSelectItemBinding

class MainTopBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy { MainSelectItemBinding.inflate(LayoutInflater.from(context), this, true) }


    init {
        binding.isSelectCheckBox.setOnClickListener {

        }
        binding.numberSelected.text = "20"
    }



}