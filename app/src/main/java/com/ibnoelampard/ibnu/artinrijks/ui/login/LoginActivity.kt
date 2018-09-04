package com.ibnoelampard.ibnu.artinrijks.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseActivity
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivity
import com.ibnoelampard.ibnu.artinrijks.ui.register.RegisterActivity
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_toolbar.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class LoginActivity : BaseActivity<LoginActivityPresenter>(), LoginActivityView, View.OnClickListener {
    @Inject
    lateinit var popUpDialog: PopUpDialog

    companion object {
        fun getInstance(activity: Activity) {
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnLogin ->{
                presenter.doLogin(edtUsername.text.toString(), edtPassword.text.toString())
            }
            R.id.btnRegister -> {
                RegisterActivity.getInstance(this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun initView(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            btnRegister.text = Html.fromHtml(getString(R.string.text_dont_have), Html.FROM_HTML_MODE_COMPACT)
        } else {
            btnRegister.text = Html.fromHtml(getString(R.string.text_dont_have))
        }
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
    }

    override fun instantiatePresenter(): LoginActivityPresenter {
        return LoginActivityPresenter(this)
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

    override fun showError(error: String) {
        popUpDialog.showErrorDialog(error)

    }

    override fun successLogin() {
        MainActivity.getInstance(this)
    }
}
