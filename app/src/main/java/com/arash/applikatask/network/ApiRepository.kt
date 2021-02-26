package com.arash.applikatask.network

import com.arash.applikatask.model.arz.ResponseArzItem
import com.arash.applikatask.model.car.ResponseCar
import com.arash.applikatask.model.seke.ResponseSekeItem

interface ApiRepository {
    suspend fun getArzData(): List<ResponseArzItem>
    suspend fun getSekeData(): List<ResponseSekeItem>
    suspend fun getCarData(): ResponseCar
}