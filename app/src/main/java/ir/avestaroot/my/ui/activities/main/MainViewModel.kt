package ir.avestaroot.my.ui.activities.main

import android.app.Application
import androidx.lifecycle.*
import ir.avestaroot.my.data.mediaStore.MediaStoreHelper
import ir.avestaroot.my.data.model.ContentItem
import ir.avestaroot.my.data.model.LoadingState
import ir.avestaroot.my.data.model.event.Event
import ir.avestaroot.my.util.FragmentNavigator
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mediaStoreHelper by lazy { MediaStoreHelper(application.contentResolver) }

    private val _contentsList = MutableLiveData<Event<ArrayList<ContentItem>>>()
    val contentsList: LiveData<Event<ArrayList<ContentItem>>>
        get() = _contentsList

    private val _currentFragment = MutableLiveData<FragmentNavigator.Fragments>()
    val currentFragment: LiveData<FragmentNavigator.Fragments>
        get() = _currentFragment

    private val _loadingState = MutableLiveData<Event<LoadingState>>()
    val loadingState: LiveData<Event<LoadingState>>
        get() = _loadingState

    fun onCurrentFragmentChange(fragment: FragmentNavigator.Fragments) {
        _currentFragment.value = fragment
    }

    fun onLoadingChanged(state: LoadingState) {
        _loadingState.value = Event(state)
    }

    fun loadContents() {
        viewModelScope.launch {
            val contents = mediaStoreHelper.getContents(_currentFragment.value!!)

            _contentsList.postValue(Event(contents))
        }
    }
}