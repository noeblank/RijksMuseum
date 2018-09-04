package com.ibnoelampard.ibnu.artinrijks.ui.login

import com.ibnoelampard.ibnu.artinrijks.base.BaseView

interface LoginActivityView : BaseView {
    fun successLogin()
    fun showErrorUsername(error: String)
    fun showErrorPassword(error: String)
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}
