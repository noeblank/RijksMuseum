package com.ibnoelampard.ibnu.artinrijks.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseActivity
import com.ibnoelampard.ibnu.artinrijks.model.RijksMuseumModel
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import com.ibnoelampard.ibnu.artinrijks.utils.general.RIJKS_DATA
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.view_toolbar.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class DetailActivity : BaseActivity<DetailActivityPresenter>(), DetailActivityView {
    @Inject
    lateinit var popUpDialog: PopUpDialog
    private lateinit var rijksMuseumModel: RijksMuseumModel

    companion object {
        fun getInstance(activity: Activity, bundle: Bundle) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        rijksMuseumModel = intent.extras.getParcelable(RIJKS_DATA)
        initToolbar()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        titleBar.text = getString(R.string.text_detail)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initView(){
        Picasso.get().load(rijksMuseumModel.url)
                .placeholder(R.drawable.ic_art_in_rijks_big)
                .error(R.drawable.ic_art_in_rijks_big)
                .fit()
                .centerCrop()
                .into(ivArt)
        tvTitle.text = rijksMuseumModel.title

    }

    override fun instantiatePresenter(): DetailActivityPresenter {
        return DetailActivityPresenter(this)
    }

    override fun showLoading() {
        popUpDialog.showProgress()
    }

    override fun hideLoading() {
        popUpDialog.disminProgress()
    }


    override fun showError(error: String) {
        popUpDialog.showErrorDialog(error)
    }

}
