package com.arash.applikatask.model.car


import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ResponseCar(
    @Json(name = "Ok")
    val ok: Boolean?,
    @Json(name = "Result")
    val result: List<Result>?
) : Parcelable