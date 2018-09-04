package com.ibnoelampard.ibnu.artinrijks.ui.profile

import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject

class ProfileFragmentPresenter(postView: ProfileFragmentView) : BasePresenter<ProfileFragmentView>(postView) {

    @Inject
    lateinit var realmHelper: RealmHelper

    override fun onViewCreated() {
        loadData()
    }

    override fun onViewDestroyed() {}

    fun loadData(){
        val user = realmHelper.getUserSession()
        if (user != null){
            view.setUsername(user.username!!)
        }
    }

    fun doLogout(){
        realmHelper.logout()
        view.successLogout()
    }
}
