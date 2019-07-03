package com.example.feature2

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import com.example.core_data.BlackBoard
import com.example.core_data.IntentNavigationManager
import com.example.core_utils.di.CoreDaggerActivity
import com.example.core_utils.di.ViewModelFactory
import com.example.core_utils.identity
import com.example.core_utils.showToast
import com.example.feature2.databinding.ActivityFeature2Binding
import javax.inject.Inject

class Feature2Activity : CoreDaggerActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature2ActivityViewModel
    lateinit var activityMainBinding: ActivityFeature2Binding

    @Inject
    lateinit var blackBoard: BlackBoard

    @Inject
    lateinit var intentNavigationManager: IntentNavigationManager

    @Inject
    lateinit var repository: Feature2Repository

    @Inject
    lateinit var data: Feature2Data

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
                text = "Print Identities"
                onClick {
                    intentNavigationManager.printHashCode("2")
                    blackBoard.printHashCode("2")
                    this.identity("2")
                    mainActivityViewModel.identity("ViewModel 2")
                    repository.identity("Repository 2")
                    data.identity("Data 2")
                }
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

            button {
                text = "Move To Feature 3"
                onClick {
                    val intent = intentNavigationManager.goToFeature3(context)
                    intent?.let {
                        context.startActivity(it)
                        finish()
                    } ?: showToast("Feature 3 not loaded")
                }
            }
        }
    }
}
