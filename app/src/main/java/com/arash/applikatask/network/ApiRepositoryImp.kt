package com.arash.applikatask.network

import com.arash.applikatask.model.arz.ResponseArzItem
import com.arash.applikatask.model.car.ResponseCar
import com.arash.applikatask.model.seke.ResponseSekeItem

class ApiRepositoryImp(private val apiService: ApiService): ApiRepository {

    override suspend fun getArzData(): List<ResponseArzItem>{
        return apiService.getArzData()
    }

    override suspend fun getSekeData(): List<ResponseSekeItem> {
        return apiService.getSekeData()
    }

    override suspend fun getCarData(): ResponseCar {
        return apiService.getCarData()
    }

}