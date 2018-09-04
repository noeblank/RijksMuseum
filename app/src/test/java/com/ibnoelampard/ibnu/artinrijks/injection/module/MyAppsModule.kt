package com.ibnoelampard.ibnu.artinrijks.injection.module

import android.app.Application
import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.ProgressLoadingView
import com.ibnoelampard.ibnu.artinrijks.utils.general.GlobalFunction
import dagger.Module
import dagger.Provides

@Module
@Suppress("unused")
object MyAppsModule {
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }

    @Provides
    @JvmStatic
    internal fun provideAppProgressLoading(context: Context): ProgressLoadingView {
        return ProgressLoadingView(context)
    }

    @Provides
    @JvmStatic
    internal fun provideRealmHelper(): RealmHelper {
        return RealmHelper()
    }

    @Provides
    @JvmStatic
    internal fun providePopUpDialog(context: Context): PopUpDialog {
        return PopUpDialog(context)
    }

    @Provides
    @JvmStatic
    internal fun provideGlobalFunction(context: Context): GlobalFunction {
        return GlobalFunction(context)
    }
}