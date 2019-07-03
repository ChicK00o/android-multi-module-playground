package com.example.feature4

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
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
import com.example.feature4.databinding.ActivityFeature4Binding
import com.example.feature4a.Feature4aActivity
import com.example.feature4b.Feature4bActivity
import com.example.feature4scope.iFeature4ScopedData
import javax.inject.Inject

class Feature4Activity : CoreDaggerActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainActivityViewModel: Feature4ActivityViewModel
    lateinit var activityMainBinding: ActivityFeature4Binding

    @Inject
    lateinit var blackBoard: BlackBoard

    @Inject
    lateinit var intentNavigationManager : IntentNavigationManager

    @Inject
    lateinit var repository: Feature4Repository

    @Inject
    lateinit var data: Feature4Data

    @Inject
    lateinit var impl: iFeature4ScopedData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature4)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)[Feature4ActivityViewModel::class.java]
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_feature4)
        activityMainBinding.viewModel = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this

        DevDrawer.attachTo(this, gravity = Gravity.END) {

            checkbox {
                text = "Enable logging"
                onCheckedChange { isChecked ->
                    showToast("Logging enabled: $isChecked")
                    mainActivityViewModel.setText("feature4! Check Clicked")
                }
            }

            switch {
                text = "God mode"
                onCheckedChange { isChecked ->
                    showToast("God mode switched: $isChecked")
                    mainActivityViewModel.setText("feature4! God Switched")
                }
            }

            button {
                text = "Print Identities"
                onClick {
                    intentNavigationManager.printHashCode("4")
                    blackBoard.printHashCode("4")
                    this.identity("4")
                    mainActivityViewModel.identity("ViewModel 4")
                    repository.identity("Repository 4")
                    data.identity("Data 4")
                    impl.identity("Interface 4")
                }
            }

            spinner {
                item { "Auto" }
                addItem("Dark")
                item { "Light" }

                onItemSelected { item, position ->
                    showToast("$item at $position")
                    mainActivityViewModel.setText("feature4! $item Selected")
                }
            }

            button {
                text = "Move To Main Activity"
                onClick {
                    finish()
                }
            }

            button {
                text = "Move To Feature 4a"
                onClick {
                    val intent = enrichIntent(Intent(context, Feature4aActivity::class.java))
                    context.startActivity(intent)
                }
            }

            button {
                text = "Move To Feature 4b"
                onClick {
                    val intent = enrichIntent(Intent(context, Feature4bActivity::class.java))
                    context.startActivity(intent)
                }
            }
        }
    }
}
