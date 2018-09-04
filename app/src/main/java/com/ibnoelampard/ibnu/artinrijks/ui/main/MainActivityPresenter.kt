package com.ibnoelampard.ibnu.artinrijks.ui.main

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject
class MainActivityPresenter(postView: MainActivityView) : BasePresenter<MainActivityView>(postView) {
    @Inject
    lateinit var realmHelper: RealmHelper

    @Inject
    lateinit var context: Context

    override fun onViewCreated() {}

    override fun onViewDestroyed() {}

    fun loadData(){
        val user = realmHelper.getUserSession()
        if (user != null){
            view.setUsername(user.username!!)
        }
    }
}
