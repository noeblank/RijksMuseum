package com.ibnoelampard.ibnu.artinrijks.ui.login

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.model.SessionUserRealmData
import com.ibnoelampard.ibnu.artinrijks.utils.general.GlobalFunction
import com.ibnoelampard.ibnu.artinrijks.utils.general.HASH
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject

class LoginActivityPresenter(postView: LoginActivityView) : BasePresenter<LoginActivityView>(postView) {
    @Inject
    lateinit var context: Context
    @Inject
    lateinit var realmHelper: RealmHelper
    @Inject
    lateinit var globalFunction: GlobalFunction

    override fun onViewCreated() {}

    override fun onViewDestroyed() {}

    fun doLogin(username: String, password: String) {
        if (!globalFunction.isNotNull(username) && !globalFunction.isNotNull(password)){
            view.showErrorUsername(context.getString(R.string.err_msg_username_password))
            return
        } else if(!globalFunction.isNotNull(username)){
            view.showErrorUsername(context.getString(R.string.err_msg_username))
            return
        }
        else if(!globalFunction.isNotNull(password)){
            view.showErrorPassword(context.getString(R.string.err_msg_password))
            return
        }
        val user = realmHelper.getUserByUsernameAndPassword(username, HASH.md5(password))
        if (user != null){
            realmHelper.add(SessionUserRealmData(user.username, user.password))
            view.successLogin()
        } else {
            view.showError(context.getString(R.string.err_msg_authentication))
        }
    }
}
