package com.example.android_playground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import timber.log.Timber
import utils.showToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked -> showToast("Logging enabled: $isChecked") }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked -> showToast("God mode switched: $isChecked") }
            }

            button {
                text = "Crash"
                onClick { throw Exception("Intended crash") }
            }

            spinner {
                item { "Auto" }
                addItem("Dark")
                item { "Light" }

                onItemSelected { item, position -> showToast("$item at $position") }
            }
        }

        Timber.tag("LifeCycles")
        Timber.d("Activity Created")
    }
}
