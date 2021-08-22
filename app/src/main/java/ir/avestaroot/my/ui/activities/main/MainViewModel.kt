package ir.avestaroot.my.ui.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.avestaroot.my.util.FragmentNavigator

class MainViewModel : ViewModel() {

    private val _currentFragment = MutableLiveData<FragmentNavigator.Fragments>()
    val currentFragment: LiveData<FragmentNavigator.Fragments>
        get() = _currentFragment

    fun onCurrentFragmentChange(fragment: FragmentNavigator.Fragments) {
        _currentFragment.value = fragment
    }
}