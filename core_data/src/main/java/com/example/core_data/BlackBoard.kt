package com.example.core_data

import com.example.core_utils.identity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BlackBoard @Inject constructor() {

    fun printHashCode(postfix : String) {
        this.identity("Blackboard $postfix")
    }
}