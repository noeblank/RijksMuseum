package com.ibnoelampard.ibnu.artinrijks.ui.splashscreen

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject

class SplashActivityPresenter(postView: SplashActivityView) : BasePresenter<SplashActivityView>(postView) {
    @Inject
    lateinit var context: Context
    @Inject
    lateinit var realmHelper: RealmHelper

    override fun onViewCreated() {}

    override fun onViewDestroyed() {}

    fun doChekSession() {
        val user = realmHelper.getUserSession()
        view.updatePosts(user != null)
    }
}
