package com.ibnoelampard.ibnu.artinrijks.ui.splashscreen

import android.support.annotation.StringRes
import com.ibnoelampard.ibnu.artinrijks.base.BaseView

interface SplashActivityView : BaseView {
    fun updatePosts(isLogged: Boolean)
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
    fun showLoading()
    fun hideLoading()
}
