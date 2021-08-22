package ir.avestaroot.my.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ir.avestaroot.my.ui.fragments.MainFragment
import ir.avestaroot.my.ui.fragments.content.ContentFragment

class FragmentNavigator(
    private val supportFragmentManager: FragmentManager,
    private val container: Int
) {

    fun navigateTo(fragment: Fragments) {
        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment.fragment)
            .addToBackStack(null)
            .commit()
    }

    enum class Fragments(val fragment: Fragment) {
        Main(MainFragment.newInstance()),
        Images(ContentFragment.newInstance()),
        Videos(ContentFragment.newInstance()),
        Audio(ContentFragment.newInstance()),
        Documents(ContentFragment.newInstance()),
        Downloads(ContentFragment.newInstance()),
        InstallationsFiles(ContentFragment.newInstance())
    }
}