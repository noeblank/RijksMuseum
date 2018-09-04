package com.ibnoelampard.ibnu.artinrijks.utils.general

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import java.text.SimpleDateFormat
import java.util.*

open class GlobalController{
    companion object {

        fun getRegularCustomFont(context: Context?): Typeface {
            return if (context == null) {
                Typeface.DEFAULT
            } else Typeface.createFromAsset(context.assets, "fonts/Roboto-Regular.ttf")
        }

        fun getThinCustomFont(context: Context?): Typeface {
            return if (context == null) {
                Typeface.DEFAULT
            } else Typeface.createFromAsset(context.assets, "fonts/Roboto-Thin.ttf")
        }

        fun getBlackCustomFont(context: Context?): Typeface {
            return if (context == null) {
                Typeface.DEFAULT
            } else Typeface.createFromAsset(context.assets, "fonts/Roboto-Black.ttf")
        }

        @SuppressLint("SimpleDateFormat")
        fun dateFormater(timeMilis:Long, dateFormat:String): String? {
            val formatter = SimpleDateFormat(dateFormat)
            val calendar = Calendar.getInstance()
            calendar.setTimeInMillis(timeMilis)
            return formatter.format(calendar.getTime())
        }

        @SuppressLint("SimpleDateFormat")
        fun getDayOfWeek(timeMilis: Long): String {
            val calendar = Calendar.getInstance()
            val formatter = SimpleDateFormat("EEEE")
            calendar.timeInMillis = timeMilis
            return formatter.format(calendar.time)
        }

        fun isNotNull(text: String?): Boolean {
            var text: String? = text ?: return false
            text = text!!.trim { it <= ' ' }
            return text != ""
        }
    }
}