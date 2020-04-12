package com.alext.myrunning.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode

class RunSplitsViewModel: ViewModel() {

    val selectedDistance = MutableLiveData<String>("")
    val selectedTime = MutableLiveData<String>("")
    val pace = MutableLiveData<String>()

    fun calculatePace() {
        pace.postValue((BigDecimal(selectedTime.value).setScale(5) / BigDecimal(selectedDistance.value).setScale(5)).setScale(2).toPlainString())
    }
}