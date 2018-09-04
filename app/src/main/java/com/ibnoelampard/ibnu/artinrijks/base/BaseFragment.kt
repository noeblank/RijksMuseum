package com.ibnoelampard.ibnu.artinrijks.base

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import com.ibnoelampard.ibnu.artinrijks.inject.component.DaggerFragmentInjector
import com.ibnoelampard.ibnu.artinrijks.inject.component.FragmentInjector
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.ui.home.HomeFragment
import com.ibnoelampard.ibnu.artinrijks.ui.profile.ProfileFragment

abstract class BaseFragment<P : BasePresenter<BaseView>> : BaseView, Fragment() {
    protected lateinit var presenter: P
    private lateinit var injector: FragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
        injector = DaggerFragmentInjector
                .builder()
                .myAppsModule(MyAppsModule)
                .networkModule(APIModule)
                .baseView(presenter.view)
                .build()
        inject()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return activity
    }

    private fun inject() {
        when (this) {
            is ProfileFragment      -> injector.inject(this)
            is HomeFragment         -> injector.inject(this)

        }
    }
}
