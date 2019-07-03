package com.example.core_data

import com.example.core_utils.di.AppScope
import com.example.core_utils.identity
import javax.inject.Inject

@AppScope
class BlackBoard @Inject constructor() {

    fun printHashCode(postfix : String) {
        this.identity("Blackboard $postfix")
    }
}