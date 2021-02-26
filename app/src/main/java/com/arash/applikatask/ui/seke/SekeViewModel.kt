package com.arash.applikatask.ui.seke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arash.applikatask.model.localdbmodel.DbModel

class SekeViewModel : ViewModel() {
    private val _list = MutableLiveData<List<DbModel>>()
    val list : LiveData<List<DbModel>>
        get() = _list

    fun updateList(list: List<DbModel>) {
        _list.value = list
    }
}