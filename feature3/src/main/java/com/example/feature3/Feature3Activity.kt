package com.example.feature3

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import com.example.core_utils.di.ViewModelFactory
import com.example.core_utils.showToast
import com.example.feature3.databinding.ActivityFeature3Binding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class Feature3Activity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature3ActivityViewModel
    lateinit var activityMainBinding: ActivityFeature3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature3)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[Feature3ActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_feature3)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("feature3! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("feature3! God Switched")
                }
            }

            button {
                text = "Crash"
                onClick { throw Exception("Intended crash") }
            }

            spinner {
                item { "Auto" }
                addItem("Dark")
                item { "Light" }

                onItemSelected { item, position ->
                    showToast("$item at $position")
                    mainActivityViewModel.setText("feature3! $item Selected")
                }
            }

            button {
                text = "Move To Main Activity"
                onClick {
                    finish()
                }
            }
        }
    }
}
