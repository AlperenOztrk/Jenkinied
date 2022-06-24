package com.c24.jenkinied

import android.util.Log

val Any.TAG: String
    get() = this::class.java.simpleName


fun Any.logNow(msg: String) {
    Log.d(this.TAG, msg)
}