package com.example.core_utils.di

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class CoreDaggerActivity : AppCompatActivity(),
    HasFragmentInjector,
    HasSupportFragmentInjector,
    HasActivityInjector
{
    @set:Inject
    var activityInjector : DispatchingAndroidInjector<Activity>? = null
    @set:Inject
    var supportFragmentInjector: DispatchingAndroidInjector<Fragment>? = null
    @set:Inject
    var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>? = null

    private var baseBundle = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        intent.extras?.let {bundle ->
            baseBundle = bundle.getString(SubComponentsInjectors.bundleKey)?:""
        }
        if(!SubComponentsInjectors.getAndroidActivityInjector(baseBundle).maybeInject(this)) {
            SubComponentsInjectors.getAndroidActivityInjector(SubComponentsInjectors.applicationKey).inject(this)
        }
        super.onCreate(savedInstanceState)
        this.javaClass.kotlin.qualifiedName?.let {name ->
            activityInjector?.let {injector ->
                SubComponentsInjectors.addAndroidActivityInjector(baseBundle + name, injector)
            }
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return supportFragmentInjector
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment>? {
        return frameworkFragmentInjector
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityInjector
    }

    fun enrichIntent(intent: Intent) : Intent {
        this.javaClass.kotlin.qualifiedName?.let {name ->
            return intent.putExtra(SubComponentsInjectors.bundleKey, baseBundle + name)
        } ?: return intent
    }

    fun getBaseBundle() : String {
        return baseBundle
    }
}