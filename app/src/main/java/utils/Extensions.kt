package utils

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.widget.Toast


fun Context.showToast(msg: String) {
    toast(msg).show()
}

fun Context.toast(msg: String): Toast {
    return Toast.makeText(this, msg, Toast.LENGTH_SHORT)
}

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }