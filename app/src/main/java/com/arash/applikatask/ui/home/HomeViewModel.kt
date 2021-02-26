package com.arash.applikatask.ui.home

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arash.applikatask.localdb.PriceRepository
import com.arash.applikatask.model.arz.ResponseArzItem
import com.arash.applikatask.model.car.ResponseCar
import com.arash.applikatask.model.localdbmodel.DbModel
import com.arash.applikatask.model.seke.ResponseSekeItem
import com.arash.applikatask.network.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(private val apiRepository: ApiRepository,application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    private val _dollarPrice = MutableLiveData<String>("10000")
    val dollarPrice: LiveData<String>
        get() = _dollarPrice

    private val _responseArz = MutableLiveData<List<ResponseArzItem>>()
    val responseArz: LiveData<List<ResponseArzItem>>
        get() = _responseArz

    private val _responseSeke = MutableLiveData<List<ResponseSekeItem>>()
    val responseSeke: LiveData<List<ResponseSekeItem>>
        get() = _responseSeke

    private val _responseCar = MutableLiveData<ResponseCar>()
    val responseCar: LiveData<ResponseCar>
        get() = _responseCar


    fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                PriceRepository.deleteData(context)
                _responseSeke.postValue(apiRepository.getSekeData())
                _responseArz.postValue(apiRepository.getArzData())
                _responseCar.postValue(apiRepository.getCarData())
                Timber.e("ok")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun insertData(
        context: Context,
        dbModel: DbModel
    ) {
        PriceRepository.insertData(
            context,
            dbModel.Name,
            dbModel.Price,
            dbModel.Change,
            dbModel.Percent,
            dbModel.Kind
        )
    }
}