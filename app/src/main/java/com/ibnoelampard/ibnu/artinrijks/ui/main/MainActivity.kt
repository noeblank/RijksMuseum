package com.ibnoelampard.ibnu.artinrijks.ui.main

import android.app.Activity
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseActivity
import com.ibnoelampard.ibnu.artinrijks.ui.home.HomeFragment
import com.ibnoelampard.ibnu.artinrijks.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class MainActivity : BaseActivity<MainActivityPresenter>(), MainActivityView, NavigationView.OnNavigationItemSelectedListener{
    lateinit var viewProfile: LinearLayout
    lateinit var ivProfile: ImageView
    lateinit var tvProfileName: TextView

    companion object {
        fun getInstance(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialView()
        presenter.loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun initialView(){
        ivProfile = navView.getHeaderView(0).findViewById(R.id.ivProfile)
        tvProfileName = navView.getHeaderView(0).findViewById(R.id.tvProfileName)
        viewProfile = navView.getHeaderView(0).findViewById(R.id.viewProfile)
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        onNavigationItemSelected(navView.getMenu().getItem(0));
        navView.setCheckedItem(R.id.nav_home)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun instantiatePresenter(): MainActivityPresenter {
        return MainActivityPresenter(this)
    }

    override fun setUsername(userName: String) {
        tvProfileName.text = "Welcome, $userName"
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                titleBar.text = getString(R.string.text_home)
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.nav_profile -> {
                titleBar.text = getString(R.string.text_profile)
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
