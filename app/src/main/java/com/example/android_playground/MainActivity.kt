package com.example.android_playground

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import dagger.android.support.DaggerAppCompatActivity
import com.example.core_utils.di.ViewModelFactory
import timber.log.Timber
import com.example.core_utils.showToast
import javax.inject.Inject
import com.example.android_playground.databinding.ActivityMainBinding
import com.example.feature2.Feature2Activity

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("Hello World! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("Hello World! God Switched")
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
                    mainActivityViewModel.setText("Hello World! $item Selected")
                }
            }

            button {
                text = "Move To Feature 2"
                onClick {
                    var intent = Intent(this.context, Feature2Activity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        Timber.tag("LifeCycles")
        Timber.d("Activity Created")
    }
}
