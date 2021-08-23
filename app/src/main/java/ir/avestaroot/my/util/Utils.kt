package ir.avestaroot.my.util

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.data.model.event.Event


fun Fragment.mToast(res: Int) = Toast.makeText(requireContext(), getString(res), Toast.LENGTH_SHORT).show()

fun View.beVisible() {
    this.visibility = View.VISIBLE
}

fun View.beGone() {
    this.visibility = View.GONE
}