package ir.avestaroot.my.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.FragmentContentBinding
import ir.avestaroot.my.databinding.NavigationItemMenuBinding

class navigationItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy {
        NavigationItemMenuBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }
    private val bindingFragment by lazy {
        FragmentContentBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }


    init {
        binding.Copy.setOnClickListener {
            Toast.makeText(getContext(), "copy", Toast.LENGTH_SHORT).show()
        }
        binding.Move.setOnClickListener {
            Toast.makeText(getContext(), "move", Toast.LENGTH_SHORT).show()
        }
        binding.Details.setOnClickListener {
            Toast.makeText(getContext(), "details", Toast.LENGTH_SHORT).show()
        }
        binding.Delete.setOnClickListener {
            Toast.makeText(getContext(), "Delete", Toast.LENGTH_SHORT).show()
        }
        binding.Share.setOnClickListener {
            Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show()
        }
    }

    fun setOpenNavigationBar() {


            val animation = AnimationUtils.loadAnimation(context, R.anim.drop)
            bindingFragment.navigationItem.startAnimation(animation)



    }

    fun setCloseNavigationBar() {


            val animation = AnimationUtils.loadAnimation(context, R.anim.slide_down)
            bindingFragment.navigationItem.startAnimation(animation)

    }
}