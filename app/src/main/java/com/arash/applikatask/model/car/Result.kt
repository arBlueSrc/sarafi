package com.arash.applikatask.model.car


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Result(
    @Json(name = "bazar")
    val bazar: String?,
    @Json(name = "karkhane")
    val karkhane: String?,
    @Json(name = "moshakhasat")
    val moshakhasat: String?,
    @Json(name = "name")
    val name: String?
) : Parcelable