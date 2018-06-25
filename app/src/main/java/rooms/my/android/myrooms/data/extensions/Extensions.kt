package rooms.my.android.myrooms.data.extensions

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * Return a [Observer] of non-nulls values
 */
fun <T> createObserverNotNull(work: (T) -> Unit): Observer<T> {
    val observer: Observer<T> = Observer { value -> value?.let { work(it) } }
    return observer
}

/**
 * Observe the [LiveData] for changes of only non-null values
 */
fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, work: (T) -> Unit) : Observer<T> {

    val observer: Observer<T> = createObserverNotNull(work)
    observe(owner,  observer)
    return observer

}