package com.ibnoelampard.ibnu.artinrijks.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ibnoelampard.ibnu.artinrijks.inject.component.ActivityInjector
import com.ibnoelampard.ibnu.artinrijks.inject.component.DaggerActivityInjector
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.ui.detail.DetailActivity
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivity
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivity
import com.ibnoelampard.ibnu.artinrijks.ui.register.RegisterActivity
import com.ibnoelampard.ibnu.artinrijks.ui.splashscreen.SplashActivity

abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: P
    private lateinit var injector: ActivityInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
        injector = DaggerActivityInjector
                .builder()
                .myAppsModule(MyAppsModule)
                .networkModule(APIModule)
                .baseView(presenter.view)
                .build()
        inject()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }

    private fun inject() {
        when (this) {
            is SplashActivity   -> injector.inject(this)
            is LoginActivity    -> injector.inject(this)
            is RegisterActivity -> injector.inject(this)
            is MainActivity     -> injector.inject(this)
            is DetailActivity   -> injector.inject(this)

        }
    }
}
