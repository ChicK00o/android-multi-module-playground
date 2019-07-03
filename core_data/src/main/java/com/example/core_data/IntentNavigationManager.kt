package com.example.core_data

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.core_utils.di.AppScope
import com.example.core_utils.identity
import javax.inject.Inject

@AppScope
class IntentNavigationManager @Inject constructor() {

    fun printHashCode(postfix: String) {
        this.identity("Navigation Manager $postfix")
    }

    private val classMap = mutableMapOf<String, Class<*>>()

    private inline fun <reified T : Any> Any.castOrNull() = this as? T

    private fun <T> String.loadClassOrNull(): Class<out T>? =
        classMap.getOrPut(this) {
            try {
                Class.forName(this)
            } catch (e: ClassNotFoundException) {
                return null
            }
        }.castOrNull()

    fun goToFeature2(context: Context) : Intent? {
        return "com.example.feature2.Feature2Activity".loadClassOrNull<Activity>()
            .let { Intent(context, it) }
    }

    fun goToFeature3(context: Context) : Intent? {
        return "com.example.feature3.Feature3Activity".loadClassOrNull<Activity>()
            .let { Intent(context, it) }
    }

    fun goToFeature4(context: Context) : Intent? {
        return "com.example.feature4.Feature4Activity".loadClassOrNull<Activity>()
            .let { Intent(context, it) }
    }

    //Not Needed as no one is going to Main activity themselves
//    fun goToMainActivity(context: Context) : Intent? {
//        return "com.example.android_playground.MainActivity".loadClassOrNull<Activity>()
//            .let { Intent(context, it) }
//    }
}