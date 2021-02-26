package com.arash.applikatask.network

import com.arash.applikatask.model.arz.ResponseArzItem
import com.arash.applikatask.model.car.ResponseCar
import com.arash.applikatask.model.seke.ResponseSekeItem
import retrofit2.http.GET

interface ApiService {

    @GET("/arz/?type=arz")
    suspend fun getArzData(): List<ResponseArzItem>

    @GET("/arz/?type=tala")
    suspend fun getSekeData(): List<ResponseSekeItem>

    @GET("/car-price")
    suspend fun getCarData(): ResponseCar

}