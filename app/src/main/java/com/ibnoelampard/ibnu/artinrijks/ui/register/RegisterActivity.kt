package com.ibnoelampard.ibnu.artinrijks.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseActivity
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity<RegisterActivityPresenter>(), RegisterActivityView, View.OnClickListener {
    @Inject
    lateinit var popUpDialog: PopUpDialog

    companion object {
        fun getInstance(activity: Activity) {
            val intent = Intent(activity, RegisterActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView(){
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnRegister ->{
                presenter.doRegister(edtUsername.text.toString(), edtPassword.text.toString(), checkTnc.isChecked)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun instantiatePresenter(): RegisterActivityPresenter {
        return RegisterActivityPresenter(this)
    }

    override fun showLoading() {
        popUpDialog.showProgress()
    }

    override fun hideLoading() {
        popUpDialog.disminProgress()
    }

    override fun showErrorUsername(error: String) {
        edtUsername.error = error
        edtUsername.requestFocus()
    }

    override fun showErrorPassword(error: String) {
        edtPassword.error = error
        edtPassword.requestFocus()
    }

    override fun showErrorTnc(error: String) {
        checkTnc.error = error
        checkTnc.requestFocus()
    }

    override fun showError(error: String) {
        popUpDialog.showErrorDialog(error)
    }

    override fun successRegister() {
        popUpDialog.showErrorDialog(
                "Register",
                "Success Register", object : PopUpDialog.DialogClickListener{
            override fun onPositifClick(TAG: String) {
                finish()
            }
            override fun onNegativeClick(TAG: String) {}
        })
    }


}
