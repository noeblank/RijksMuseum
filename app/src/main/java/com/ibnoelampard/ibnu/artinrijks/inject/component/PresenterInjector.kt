package com.ibnoelampard.ibnu.artinrijks.inject.component

import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.ui.detail.DetailActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.home.HomeFragmentPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.profile.ProfileFragmentPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.register.RegisterActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.splashscreen.SplashActivityPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MyAppsModule::class), (APIModule::class)])
interface PresenterInjector {
    fun inject(splashActivityPresenter: SplashActivityPresenter)
    fun inject(loginActivityPresenter: LoginActivityPresenter)
    fun inject(registerActivityPresenter: RegisterActivityPresenter)
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(profileFragmentPresenter: ProfileFragmentPresenter)
    fun inject(homeFragmentPresenter: HomeFragmentPresenter)
    fun inject(detailActivityPresenter: DetailActivityPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector
        fun networkModule(networkModule: APIModule): Builder
        fun myAppsModule(myAppsModule: MyAppsModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}