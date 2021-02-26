package com.arash.applikatask.model.car


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class ResponseCar(
    @Json(name = "Ok")
    val ok: Boolean?,
    @Json(name = "Result")
    val result: List<Result>?
) : Parcelable