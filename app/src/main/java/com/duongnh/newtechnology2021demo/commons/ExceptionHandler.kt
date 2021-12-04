package com.duongnh.newtechnology2021demo.commons

import androidx.annotation.StringRes
import com.duongnh.newtechnology2021demo.R
import java.net.UnknownHostException

internal object ExceptionHandler {
    @StringRes
    fun parse(t: Throwable): Int {
        t.printStackTrace()
        return when (t) {
            is UnknownHostException -> R.string.error_check_internet_connection
            else -> R.string.error_oops_error_occured
        }
    }
}