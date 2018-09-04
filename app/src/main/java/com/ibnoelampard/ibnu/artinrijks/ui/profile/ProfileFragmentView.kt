package com.ibnoelampard.ibnu.artinrijks.ui.profile

import android.support.annotation.StringRes
import com.ibnoelampard.ibnu.artinrijks.base.BaseView

interface ProfileFragmentView : BaseView {
    fun successLogout()
    fun setUsername(userName: String)
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
}
