package ir.avestaroot.my.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import ir.avestaroot.my.R
import ir.avestaroot.my.databinding.FragmentContentBinding
import ir.avestaroot.my.databinding.FragmentContentOptionsBottombarBinding
import ir.avestaroot.my.util.beGone
import ir.avestaroot.my.util.beInvisible
import ir.avestaroot.my.util.beVisible

class FragmentContentOptionsBottomBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val binding by lazy {
        FragmentContentOptionsBottombarBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    enum class Items {
        Copy,
        Move,
        Details,
        Delete,
        Share,
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

    fun open() {


        binding.root.beVisible()
        val animation = AnimationUtils.loadAnimation(context, R.anim.drop)
        binding.root.startAnimation(animation)


    }

    fun close() {

        binding.root.beInvisible()
        val animation = AnimationUtils.loadAnimation(context, R.anim.slide_down)
        binding.root.startAnimation(animation)

    }
}