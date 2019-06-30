package com.example.feature3

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import com.example.core_data.BlackBoard
import com.example.core_data.IntentNavigationManager
import com.example.core_utils.di.ViewModelFactory
import com.example.core_utils.identity
import com.example.core_utils.showToast
import com.example.feature3.databinding.ActivityFeature3Binding
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class   Feature3Activity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature3ActivityViewModel
    lateinit var activityMainBinding: ActivityFeature3Binding

    @Inject
    lateinit var blackBoard: BlackBoard

    @Inject
    lateinit var intentNavigationManager : IntentNavigationManager

    @Inject
    lateinit var repository: Feature3Repository

    @Inject
    lateinit var data: Feature3Data

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
                text = "Print Identities"
                onClick {
                    intentNavigationManager.printHashCode("3")
                    blackBoard.printHashCode("3")
                    this.identity("3")
                    mainActivityViewModel.identity("ViewModel 3")
                    repository.identity("Repository 3")
                    data.identity("Data 3")
                }
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

            button {
                text = "Move To Feature 2"
                onClick {
                    val intent = intentNavigationManager.goToFeature2(context)
                    intent?.let {
                        context.startActivity(it)
                        finish()
                    } ?: showToast("Feature 2 not loaded")
                }
            }
        }
    }
}
