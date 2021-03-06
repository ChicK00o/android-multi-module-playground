package com.example.feature4a

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
import com.example.feature4a.databinding.ActivityFeature4aBinding
import com.example.feature4scope.iFeature4ScopedData
import javax.inject.Inject

class Feature4aActivity : CoreDaggerActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature4aActivityViewModel
    lateinit var activityMainBinding: ActivityFeature4aBinding

    @Inject
    lateinit var blackBoard: BlackBoard

    @Inject
    lateinit var intentNavigationManager : IntentNavigationManager

    @Inject
    lateinit var repository: Feature4aRepository

    @Inject
    lateinit var data: Feature4aData

    @Inject
    lateinit var impl: iFeature4ScopedData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature4a)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[Feature4aActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_feature4a)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("feature4a! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("feature4a! God Switched")
                }
            }

            button {
                text = "Print Identities"
                onClick {
                    intentNavigationManager.printHashCode("${getBaseBundle()} 4a")
                    blackBoard.printHashCode("${getBaseBundle()} 4a")
                    this.identity("${getBaseBundle()} 4a")
                    mainActivityViewModel.identity("${getBaseBundle()} ViewModel 4a")
                    repository.identity("${getBaseBundle()} Repository 4a")
                    data.identity("${getBaseBundle()} Data 4a")
                    impl.identity("${getBaseBundle()} interface 4a")
                }
            }

            spinner {
                item { "Auto" }
                addItem("Dark")
                item { "Light" }

                onItemSelected { item, position ->
                    showToast("$item at $position")
                    mainActivityViewModel.setText("feature4a! $item Selected")
                }
            }

            button {
                text = "Go back"
                onClick {
                    finish()
                }
            }
        }
    }
}
