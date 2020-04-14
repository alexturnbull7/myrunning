package com.alext.myrunning.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.RoundingMode

class RunSplitsViewModel: ViewModel() {

    val selectedDistance = MutableLiveData<BigDecimal>()
    val selectedHours = MutableLiveData<BigDecimal>()
    val selectedMinutes = MutableLiveData<BigDecimal>()
    val selectedSeconds = MutableLiveData<BigDecimal>()
    val paceMinutes = MutableLiveData<String>()
    val paceSeconds = MutableLiveData<String>()

    fun calculatePace() {
        val time = (selectedHours.value!! * BigDecimal(60)) + selectedMinutes.value!! + (selectedSeconds.value!! / BigDecimal(60))
        paceMinutes.postValue((time.setScale(5) / selectedDistance.value!!.setScale(5)).setScale(0, RoundingMode.HALF_UP).toPlainString() + " Minutes")
        paceSeconds.postValue((BigDecimal((time.setScale(5) / selectedDistance.value!!.setScale(5)).toPlainString().split(".")[1]) * BigDecimal(60)).setScale(1, RoundingMode.HALF_UP).toString().first()
            .toString() + " Seconds")
    }
}