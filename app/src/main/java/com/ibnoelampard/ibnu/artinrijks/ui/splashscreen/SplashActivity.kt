package com.ibnoelampard.ibnu.artinrijks.ui.splashscreen
import android.os.Bundle
import android.os.Handler
import com.ibnoelampard.ibnu.artinrijks.base.BaseActivity
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivity
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivity

class SplashActivity : BaseActivity<SplashActivityPresenter>(), SplashActivityView {

    override fun instantiatePresenter(): SplashActivityPresenter {
        return SplashActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({openMainActivity()},SPLASH_DURATION.toLong())
    }

    private fun openMainActivity() {
        presenter.doChekSession()
    }

    override fun updatePosts(isLogged: Boolean) {
        if (isLogged){
            MainActivity.getInstance(this)
        } else {
            LoginActivity.getInstance(this)
        }
        finish()
    }

    override fun showError(error: String) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    private val SPLASH_DURATION = 2000

}
