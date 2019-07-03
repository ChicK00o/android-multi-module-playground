package com.example.feature4b

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
import com.example.feature4b.databinding.ActivityFeature4bBinding
import com.example.feature4scope.iFeature4ScopedData
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class Feature4bActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature4bActivityViewModel
    lateinit var activityMainBinding: ActivityFeature4bBinding

    @Inject
    lateinit var blackBoard: BlackBoard

    @Inject
    lateinit var intentNavigationManager : IntentNavigationManager

    @Inject
    lateinit var repository: Feature4bRepository

    @Inject
    lateinit var data: Feature4bData

    @Inject
    lateinit var impl: iFeature4ScopedData

    var bundleName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        bundleName = intent.extras!!.getString("injector")!!
        SubComponentsInjectors.getAndroidActivityInjector(bundleName).maybeInject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature4b)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[Feature4bActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_feature4b)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("feature4b! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("feature4b! God Switched")
                }
            }

            button {
                text = "Print Identities"
                onClick {
                    intentNavigationManager.printHashCode("$bundleName 4b")
                    blackBoard.printHashCode("$bundleName 4b")
                    this.identity("$bundleName 4b")
                    mainActivityViewModel.identity("$bundleName ViewModel 4b")
                    repository.identity("$bundleName Repository 4b")
                    data.identity("$bundleName Data 4b")
                    impl.identity("$bundleName interface 4b")
                }
            }

            spinner {
                item { "Auto" }
                addItem("Dark")
                item { "Light" }

                onItemSelected { item, position ->
                    showToast("$item at $position")
                    mainActivityViewModel.setText("feature4b! $item Selected")
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
