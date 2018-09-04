package com.ibnoelampard.ibnu.artinrijks

import android.content.Context
import com.ibnoelampard.ibnu.artinrijks.model.APIModelResponse
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivityPresenter
import com.ibnoelampard.ibnu.artinrijks.ui.main.MainActivityView
import com.ibnoelampard.ibnu.artinrijks.utils.POST_MOCK_PATH
import com.ibnoelampard.ibnu.artinrijks.utils.STRING_UNKNOWN_ERROR
import com.ibnoelampard.ibnu.artinrijks.utils.getTestContext
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Class containing all unit tests on PostPresenter class
 * @property view an implementation of PostView which provide us the number of times a method has been called
 * @property presenter the PostPresenter which will be tested in the tests
 */
class PostPresenterTest {
    //private val view = TestPostView()
    //private val presenter = MainActivityPresenter(view)

    /**
     * Actions to be performed before each test
     */
    @Before
    fun setUp() {
        //view.reset()
    }

    /**
     * Test that when everything is going well, loadPosts() method calls the expected method of PostView
     */
    @Test
    fun loadPosts_success() {
        /*
        POST_MOCK_PATH = "posts.json"
        presenter.loadPosts("Jakarta")
        Assert.assertEquals("Checking updatePostsCounter", 1, view.updatePostsCounter)
        Assert.assertEquals("Checking showErrorCounter", 0, view.showErrorCounter)
        Assert.assertEquals("Checking showLoadingCounter", 1, view.showLoadingCounter)
        Assert.assertEquals("Checking hideLoadingCounter", 1, view.hideLoadingCounter)
        Assert.assertEquals("Checking number of posts retrieved", 100, view.updatePostsArgs.count())
        */
    }

    /**
     * Test that when the json is not the good one, loadPosts() method calls the expected method of PostView
     */
    @Test
    fun loadPosts_failure() {
        /*
        POST_MOCK_PATH = "empty.json"
        presenter.loadPosts("Jakarta")
        Assert.assertEquals("Checking updatePostsCounter", 0, view.updatePostsCounter)
        Assert.assertEquals("Checking showErrorCounter", 1, view.showErrorCounter)
        Assert.assertEquals("Checking showLoadingCounter", 1, view.showLoadingCounter)
        Assert.assertEquals("Checking hideLoadingCounter", 1, view.hideLoadingCounter)
        Assert.assertEquals("Checking error message", STRING_UNKNOWN_ERROR, view.showErrorArgs[0])
        */
    }

    /**
     * An implementation of PostView which provide us the number of times a method has
     * been called and arguments with which it has been called
     * @property updatePostsCounter the number of times updatePosts() has been called since last reset
     * @property updatePostsArgs the parameter of each updatePosts() call since last reset
     * @property showErrorCounter the number of times showError() has been called since last reset
     * @property showErrorArgs the parameter of each showError() call since last reset
     * @property showLoadingCounter the number of times showLoading() has been called since last reset
     * @property hideLoadingCounter the number of times hideLoading() has been called since last reset
     */

    /*
    class TestPostView : MainActivityView {

        var updatePostsCounter = 0
        var updatePostsArgs: MutableList<APIModelResponse.WeatherResponse> = mutableListOf()
        var showErrorCounter = 0
        var showErrorArgs: MutableList<String> = mutableListOf()
        var showLoadingCounter = 0
        var hideLoadingCounter = 0

        /**
         * Sets all counters to 0 and all args to empty lists
         */
        fun reset() {
            updatePostsCounter = 0
            updatePostsArgs = mutableListOf()
            showErrorCounter = 0
            showErrorArgs = mutableListOf()
            showLoadingCounter = 0
            hideLoadingCounter = 0
        }

        override fun updatePosts(weatherResponse: APIModelResponse.WeatherResponse) {
            updatePostsArgs.add(weatherResponse)
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
    */
}