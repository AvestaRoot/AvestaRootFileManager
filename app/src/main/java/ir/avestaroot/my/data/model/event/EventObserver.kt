package ir.avestaroot.my.data.model.event

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnHandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(t: Event<T>?) {
        t?.getContentIfNotHandled()?.let {
            onEventUnHandledContent(it)
        }
    }
}