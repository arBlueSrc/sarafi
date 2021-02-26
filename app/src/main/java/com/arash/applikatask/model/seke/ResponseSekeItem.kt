package com.arash.applikatask.model.seke


import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ResponseSekeItem(
    @Json(name = "change")
    val change: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "percent")
    val percent: String?,
    @Json(name = "price")
    val price: String?
) : Parcelable