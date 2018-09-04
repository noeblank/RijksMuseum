package com.ibnoelampard.ibnu.artinrijks.ui.register

import android.support.annotation.StringRes
import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.model.UsersRealmData

interface RegisterActivityView : BaseView {
    fun successRegister()
    fun showErrorUsername(error: String)
    fun showErrorPassword(error: String)
    fun showErrorTnc(error: String)
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
    fun showLoading()
    fun hideLoading()
}
