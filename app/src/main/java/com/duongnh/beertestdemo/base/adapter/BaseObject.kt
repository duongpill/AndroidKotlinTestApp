package com.duongnh.beertestdemo.base.adapter

import android.os.Parcelable

abstract class BaseObject: Parcelable {
    public open val id: Int = 0
}