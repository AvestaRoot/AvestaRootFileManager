package ir.avestaroot.my.util

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.mToast(res: Int) = Toast.makeText(requireContext(), getString(res), Toast.LENGTH_SHORT).show()