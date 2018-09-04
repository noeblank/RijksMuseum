package com.ibnoelampard.ibnu.artinrijks.ui.register

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.model.UsersRealmData
import com.ibnoelampard.ibnu.artinrijks.utils.general.GlobalFunction
import com.ibnoelampard.ibnu.artinrijks.utils.general.HASH
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import javax.inject.Inject

class RegisterActivityPresenter(postView: RegisterActivityView) : BasePresenter<RegisterActivityView>(postView) {
    @Inject
    lateinit var context: Context
    @Inject
    lateinit var realmHelper: RealmHelper
    @Inject
    lateinit var globalFunction: GlobalFunction

    override fun onViewCreated() {}

    override fun onViewDestroyed() {}

    fun doRegister(username: String, password: String, isChecked: Boolean) {
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
        } else if(!isChecked){
            view.showErrorTnc(context.getString(R.string.err_check_tnc))
            return
        }
        val user = realmHelper.getUserByUsername(username)
        if (user == null){
            realmHelper.add(UsersRealmData(username, HASH.md5(password)))
            view.successRegister()
        } else {
            view.showError(context.getString(R.string.err_msg_authentication))
        }
    }
}
