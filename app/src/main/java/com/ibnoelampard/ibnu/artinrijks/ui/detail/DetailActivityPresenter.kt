package com.ibnoelampard.ibnu.artinrijks.ui.detail

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.model.SessionUserRealmData
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivityView
import com.ibnoelampard.ibnu.artinrijks.utils.general.GlobalFunction
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject

class DetailActivityPresenter(postView: DetailActivityView) : BasePresenter<DetailActivityView>(postView) {
    @Inject
    lateinit var context: Context
    @Inject
    lateinit var realmHelper: RealmHelper
    @Inject
    lateinit var globalFunction: GlobalFunction

    override fun onViewCreated() {}

    override fun onViewDestroyed() {}

}
