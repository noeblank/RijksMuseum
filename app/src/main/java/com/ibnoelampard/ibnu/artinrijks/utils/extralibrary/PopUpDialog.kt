package com.ibnoelampard.ibnu.artinrijks.utils.extralibrary

import android.content.Context
import com.afollestad.materialdialogs.DialogAction
import com.afollestad.materialdialogs.MaterialDialog
import com.ibnoelampard.ibnu.artinrijks.R

open class PopUpDialog(private var context: Context) {
    private var dialog: MaterialDialog? = null

    fun showProgress(){
        dialog = MaterialDialog.Builder(context)
                .content(R.string.text_loading)
                .progress(true, 0)
                .show()
    }

    fun disminProgress(){
        if (dialog != null){
            (dialog as MaterialDialog).dismiss()

        }
    }

    fun showErrorDialog( message:String){
        dialog = MaterialDialog.Builder(context)
                .content(message)
                .positiveText(R.string.btn_ok)
                .show()
    }

    fun showErrorDialog(title:String, message:String){
        dialog = MaterialDialog.Builder(context)
                .title(title)
                .content(message)
                .positiveText(R.string.btn_ok)
                .show()
    }

    fun showErrorDialog(title:String, message:String, listener:DialogClickListener){
        dialog = MaterialDialog.Builder(context)
                .title(title)
                .content(message)
                .positiveText(R.string.btn_ok)
                .onPositive(object : MaterialDialog.SingleButtonCallback{
                    override fun onClick(dialog: MaterialDialog, which: DialogAction) {
                        listener.onPositifClick("")
                    }
                })
                .show()
    }

    interface DialogClickListener {
        fun onPositifClick(TAG:String)
        fun onNegativeClick(TAG:String)
    }
}