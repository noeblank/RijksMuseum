package com.ibnoelampard.ibnu.artinrijks.ui.home

import com.ibnoelampard.ibnu.artinrijks.base.BaseView
import com.ibnoelampard.ibnu.artinrijks.model.RijksMuseumModel

interface HomeFragmentView : BaseView {
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
    fun successLoadData(rijksMuseumModel: ArrayList<RijksMuseumModel>)
}
