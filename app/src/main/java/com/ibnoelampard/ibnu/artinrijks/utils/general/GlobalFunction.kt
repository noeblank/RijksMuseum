package com.ibnoelampard.ibnu.artinrijks.utils.general

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import java.text.SimpleDateFormat
import java.util.*

open class GlobalFunction(private var context: Context){

    fun isNotNull(text: String?): Boolean {
        var text: String? = text ?: return false
        text = text!!.trim { it <= ' ' }
        return text != ""
    }
}