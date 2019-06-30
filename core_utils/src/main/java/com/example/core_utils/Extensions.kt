package com.example.core_utils

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.widget.Toast
import timber.log.Timber

fun Context.showToast(msg: String) {
    toast(msg).show()
}

fun Context.toast(msg: String): Toast {
    return Toast.makeText(this, msg, Toast.LENGTH_SHORT)
}

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun <T : Any> T.identity(prefix : String) {
    Timber.tag("Identity")
    Timber.i("$prefix Identity : %s", System.identityHashCode(this))
}