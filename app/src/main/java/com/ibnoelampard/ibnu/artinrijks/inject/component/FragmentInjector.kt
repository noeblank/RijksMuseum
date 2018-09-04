package com.ibnoelampard.ibnu.artinrijks.inject.component

import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.inject.module.MyAppsModule
import com.ibnoelampard.ibnu.artinrijks.inject.module.APIModule
import com.ibnoelampard.ibnu.artinrijks.ui.home.HomeFragment
import com.ibnoelampard.ibnu.artinrijks.ui.profile.ProfileFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MyAppsModule::class), (APIModule::class)])
interface FragmentInjector {
    fun inject(profileFragment: ProfileFragment)
    fun inject(homeFragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun build(): FragmentInjector
        fun networkModule(networkModule: APIModule): Builder
        fun myAppsModule(myAppsModule: MyAppsModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): FragmentInjector.Builder
    }
}