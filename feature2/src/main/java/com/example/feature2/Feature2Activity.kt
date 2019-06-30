package com.example.feature2

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class Feature2Activity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature2)
    }
}
