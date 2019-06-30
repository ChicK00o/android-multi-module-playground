package com.example.feature2

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import com.example.core_utils.di.ViewModelFactory
import com.example.core_utils.showToast
import com.example.feature2.databinding.ActivityFeature2Binding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class Feature2Activity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature2ActivityViewModel
    lateinit var activityMainBinding: ActivityFeature2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature2)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[Feature2ActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_feature2)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("Feature2! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("Feature2! God Switched")
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
                    mainActivityViewModel.setText("Feature2! $item Selected")
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
