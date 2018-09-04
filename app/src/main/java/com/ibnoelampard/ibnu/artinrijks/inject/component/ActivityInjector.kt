package com.ibnoelampard.ibnu.artinrijks.inject.component

import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.ui.detail.DetailActivity
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivity
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivity
import com.ibnoelampard.ibnu.artinrijks.ui.register.RegisterActivity
import com.ibnoelampard.ibnu.artinrijks.ui.splashscreen.SplashActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MyAppsModule::class), (APIModule::class)])
interface ActivityInjector {
    fun inject(splashActivity: SplashActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)

    @Component.Builder
    interface Builder {
        fun build(): ActivityInjector
        fun networkModule(networkModule: APIModule): Builder
        fun myAppsModule(myAppsModule: MyAppsModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): ActivityInjector.Builder
    }
}