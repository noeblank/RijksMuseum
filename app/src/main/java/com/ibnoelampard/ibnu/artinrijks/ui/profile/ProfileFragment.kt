package com.ibnoelampard.ibnu.artinrijks.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseFragment
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivity
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import javax.inject.Inject

class ProfileFragment : BaseFragment<ProfileFragmentPresenter>(), ProfileFragmentView, View.OnClickListener {

    @Inject
    lateinit var popUpDialog: PopUpDialog
    lateinit var tvUsername: TextView
    lateinit var btnLogout: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        tvUsername = view.findViewById(R.id.tvUsername)
        btnLogout = view.findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener(this)
        presenter.loadData()
        return view
    }


    override fun instantiatePresenter(): ProfileFragmentPresenter {
        return ProfileFragmentPresenter(this)
    }

    override fun successLogout() {
        LoginActivity.getInstance(activity)
        activity.finish()
    }

    override fun setUsername(userName: String) {
        tvUsername.text = userName
    }

    override fun showError(error: String) {

    }

    override fun onClick(v: View) {
       when(v.id){
           R.id.btnLogout -> {
               popUpDialog.showErrorDialog("Logout", "Are you sure to logout?", object : PopUpDialog.DialogClickListener{
                   override fun onPositifClick(TAG: String) {
                       presenter.doLogout()
                   }
                   override fun onNegativeClick(TAG: String) {}
               })
           }
       }
    }

}