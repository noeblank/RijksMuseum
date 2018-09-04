package com.ibnoelampard.ibnu.artinrijks.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.base.BaseFragment
import com.ibnoelampard.ibnu.artinrijks.model.RijksMuseumModel
import com.ibnoelampard.ibnu.artinrijks.ui.detail.DetailActivity
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.PopUpDialog
import com.ibnoelampard.ibnu.artinrijks.utils.extralibrary.ProgressLoadingView
import com.ibnoelampard.ibnu.artinrijks.utils.general.RIJKS_DATA
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentPresenter>(), HomeFragmentView, HomeAdapter.OnClickListerner {

    @Inject
    lateinit var progressLoadingView: ProgressLoadingView
    @Inject
    lateinit var popUpDialog: PopUpDialog
    lateinit var recyclerView: RecyclerView
    private lateinit var dataList:ArrayList<RijksMuseumModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        presenter.loadData()
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        progressLoadingView.setLayoutView(view.coordinatView)
        progressLoadingView.setOnClickRetry(View.OnClickListener {
            presenter.loadData()
        })
        return view
    }

    override fun instantiatePresenter(): HomeFragmentPresenter {
        return HomeFragmentPresenter(this)
    }

    override fun showError(error: String) {
        progressLoadingView.showError()
    }

    override fun showLoading() {
        progressLoadingView.showLoading()
    }

    override fun hideLoading() {
    }

    override fun successLoadData(data:ArrayList<RijksMuseumModel>) {
        dataList = data
        val adapter = HomeAdapter(dataList, this)
        recyclerView.adapter = adapter
        progressLoadingView.showData()
    }

    override fun onRecyclerViewClick(position: Int) {
        var bundle = Bundle()
        bundle.putParcelable(RIJKS_DATA, dataList.get(position))
        DetailActivity.getInstance(activity, bundle)
    }

}