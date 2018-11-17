package com.example.darkruby.musicorganizer.util

import android.databinding.ObservableField
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class PropertyChangedCallback<T>(
        private val observableField: ObservableField<T>,
        private val emitter: ObservableEmitter<T>) : android.databinding.Observable.OnPropertyChangedCallback() {
    override fun onPropertyChanged(sender: android.databinding.Observable, propertyId: Int) {
        if (sender == observableField) {
            val value:T? = observableField.get()
            if (value != null) {
                emitter.onNext(value)
            }
        }
    }
}

class Util {
    companion object {
        fun <T> toRxObservable(observableField: ObservableField<T>): Observable<T> {
            return Observable.create<T> { emitter ->
                observableField
                        .addOnPropertyChangedCallback(PropertyChangedCallback(observableField, emitter))
            }
        }
    }
}
