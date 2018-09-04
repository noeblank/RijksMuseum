package com.ibnoelampard.ibnu.artinrijks.ui.home

import com.ibnoelampard.ibnu.artinrijks.api.APIHelper
import com.ibnoelampard.ibnu.artinrijks.base.BasePresenter
import com.ibnoelampard.ibnu.artinrijks.model.RijksMuseumModel
import com.ibnoelampard.ibnu.artinrijks.utils.realm.RealmHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeFragmentPresenter(postView: HomeFragmentView) : BasePresenter<HomeFragmentView>(postView) {
    @Inject
    lateinit var postApi: APIHelper

    private var subscription: Disposable? = null

    @Inject
    lateinit var realmHelper: RealmHelper

    override fun onViewCreated() {
        loadData()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadData(){
        view.showLoading()
        subscription = postApi
                .getCollectionData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    val data:ArrayList<RijksMuseumModel> = ArrayList()
                    result.artObjects.forEach {
                        data.add(RijksMuseumModel(it.title, it.webImage.url))
                    }
                    view.successLoadData(data)
                }, { error ->
                    view.showError(error.message!!)
                })
    }

}
