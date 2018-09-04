package com.ibnoelampard.ibnu.artinrijks.base

import com.ibnoelampard.ibnu.artinrijks.inject.component.DaggerPresenterInjector
import com.ibnoelampard.ibnu.artinrijks.inject.component.PresenterInjector
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.ui.detail.DetailActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.home.HomeFragmentPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.profile.ProfileFragmentPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.register.RegisterActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.splashscreen.SplashActivityPresenter

abstract class BasePresenter<out V : BaseView>( val view: V) {
   private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .myAppsModule(MyAppsModule)
            .networkModule(APIModule)
            .build()
    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is SplashActivityPresenter      -> injector.inject(this)
            is LoginActivityPresenter       -> injector.inject(this)
            is RegisterActivityPresenter    -> injector.inject(this)
            is MainActivityPresenter        -> injector.inject(this)
            is ProfileFragmentPresenter     -> injector.inject(this)
            is HomeFragmentPresenter        -> injector.inject(this)
            is DetailActivityPresenter      -> injector.inject(this)

        }
    }
}