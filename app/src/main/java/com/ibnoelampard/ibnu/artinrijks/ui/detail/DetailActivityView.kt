package com.ibnoelampard.ibnu.artinrijks.ui.detail

import com.ibnoelampard.ibnu.artinrijks.base.BaseView

interface DetailActivityView : BaseView {
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}
