package ir.avestaroot.my.ui.activities.main

import android.app.Application
import androidx.lifecycle.*
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.util.FragmentNavigator
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _contentsList = MutableLiveData<ArrayList<ContentItem>>()
    val contentsList: LiveData<ArrayList<ContentItem>>
        get() = _contentsList

    private val _currentFragment = MutableLiveData<FragmentNavigator.Fragments>()
    val currentFragment: LiveData<FragmentNavigator.Fragments>
        get() = _currentFragment

    fun onCurrentFragmentChange(fragment: FragmentNavigator.Fragments) {
        _currentFragment.value = fragment
    }

    fun loadContents() {

    }
}