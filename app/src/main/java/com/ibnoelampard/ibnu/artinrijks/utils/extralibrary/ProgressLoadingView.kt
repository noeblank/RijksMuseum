package com.ibnoelampard.ibnu.artinrijks.utils.extralibrary

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.ibnoelampard.ibnu.artinrijks.R

open class ProgressLoadingView : RelativeLayout {

    lateinit var viewloadingAndError: View
    lateinit var view: View
    lateinit var viewLoading: LinearLayout
    lateinit var viewError: LinearLayout
    lateinit var ivLoading: ImageView
    lateinit var btnRetry: Button
    lateinit var activity: Context

    constructor(context: Context, view: View) : super(context) {
        init(context, view)
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        init(context, null)
    }

    private fun init(context: Context, view: View?) {
        activity = context
        viewloadingAndError = View.inflate(context, R.layout.progress_loading_view, this)
        viewLoading = viewloadingAndError.findViewById(R.id.viewLoading)
        viewError = viewloadingAndError.findViewById(R.id.viewError)
        ivLoading = viewloadingAndError.findViewById(R.id.ivLoading)
        btnRetry = viewloadingAndError.findViewById(R.id.btnRetry)
        val animRotateSpin = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_spin)
        ivLoading.startAnimation(animRotateSpin)
        if (view != null){
            this.view = view
            setLayoutView(view)
        }
    }

    fun setLayoutView(view: View?) {
        if (view != null){
            this.view = view
        }
        when (view) {
            is RelativeLayout -> view.addView(this)
            is LinearLayout -> view.addView(viewloadingAndError)
            is CoordinatorLayout -> view.addView(viewloadingAndError)
            is ConstraintLayout -> view.addView(viewloadingAndError)
        }
        showLoading()
    }

    fun showData() {
        viewLoading.setVisibility(View.GONE)
        viewError.setVisibility(View.GONE)
    }

    fun showLoading() {
        viewLoading.setVisibility(View.VISIBLE)
        viewError.setVisibility(View.INVISIBLE)
    }

    fun showError() {
        viewLoading.setVisibility(View.INVISIBLE)
        viewError.setVisibility(View.VISIBLE)
    }

    fun setOnClickRetry(onClickListener: View.OnClickListener) {
        btnRetry.setOnClickListener(onClickListener)
    }
}