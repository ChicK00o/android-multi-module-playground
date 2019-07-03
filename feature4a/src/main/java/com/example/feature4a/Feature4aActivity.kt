package com.example.feature4a

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import antonkozyriatskyi.devdrawer.DevDrawer
import com.example.core_data.BlackBoard
import com.example.core_data.IntentNavigationManager
import com.example.core_data.SubComponentsInjectors
import com.example.core_utils.di.ViewModelFactory
import com.example.core_utils.identity
import com.example.core_utils.showToast
import com.example.feature4a.databinding.ActivityFeature4aBinding
import com.example.feature4scope.iFeature4ScopedData
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class Feature4aActivity : AppCompatActivity() {

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

    var bundleName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        bundleName = intent.extras!!.getString("injector")!!
        SubComponentsInjectors.getAndroidActivityInjector(bundleName).maybeInject(this)
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
                    intentNavigationManager.printHashCode("$bundleName 4a")
                    blackBoard.printHashCode("$bundleName 4a")
                    this.identity("$bundleName 4a")
                    mainActivityViewModel.identity("$bundleName ViewModel 4a")
                    repository.identity("$bundleName Repository 4a")
                    data.identity("$bundleName Data 4a")
                    impl.identity("$bundleName interface 4a")
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
