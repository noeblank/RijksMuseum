package com.ibnoelampard.ibnu.artinrijks

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.login.LoginActivityView
import com.ibnoelampard.ibnu.artinrijks.utils.getTestContext
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginPresenterTest {
    private val view = TestPostView()
    private val presenter = LoginActivityPresenter(view)

    @Before
    fun setUp() {
        view.reset()
    }

    @Test
    fun loadPosts_success() {
        presenter.doLogin("","ibnu")
        Assert.assertEquals("Checking username empty", 1, view.showErrorCounter)
    }

    class TestPostView : LoginActivityView {
        override fun showErrorUsername(error: String) {

        }

        var updatePostsCounter = 0
        var showErrorCounter = 0
        var showErrorArgs: MutableList<String> = mutableListOf()
        var showLoadingCounter = 0
        var hideLoadingCounter = 0

        /**
         * Sets all counters to 0 and all args to empty lists
         */
        fun reset() {
            updatePostsCounter = 0
            showErrorCounter = 0
            showErrorArgs = mutableListOf()
            showLoadingCounter = 0
            hideLoadingCounter = 0
        }

        override fun successLogin() {
            updatePostsCounter++
        }

        override fun showError(error: String) {
            showErrorArgs.add(error)
            showErrorCounter++
        }

        override fun showLoading() {
            showLoadingCounter++
        }

        override fun hideLoading() {
            hideLoadingCounter++
        }

        override fun getContext(): Context {
            return getTestContext()
        }
    }
}