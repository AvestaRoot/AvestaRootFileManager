package ir.avestaroot.my.data.model.event

import androidx.lifecycle.Observer

class Event<T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true

            content
        }
    }

    fun getContent() = content
}