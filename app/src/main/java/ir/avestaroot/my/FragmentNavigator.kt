package ir.avestaroot.my

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentNavigator(
    private val supportFragmentManager: FragmentManager,
    private val container: Int
) {

    fun navigateTo(fragment: Fragments) {
        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment.fragment)
            .commit()
    }
}

enum class Fragments(val fragment: Fragment) {
    Main(StorageFragment.newInstance())
}