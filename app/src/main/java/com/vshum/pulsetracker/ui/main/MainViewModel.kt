package com.vshum.pulsetracker.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vshum.pulsetracker.domain.BaseConstants
import com.vshum.pulsetracker.domain.CallBack
import com.vshum.pulsetracker.domain.Record
import com.vshum.pulsetracker.ui.common.ApplicableForMineList
import com.vshum.pulsetracker.ui.common.BaseViewModel
import com.vshum.pulsetracker.ui.common.Separator
import java.text.SimpleDateFormat

class MainViewModel : BaseViewModel() {
    private var rawList: ArrayList<Record> = arrayListOf()
    private val format = SimpleDateFormat(BaseConstants.HEADER_DATA_FORMAT)
    private val yearFormat = SimpleDateFormat(BaseConstants.HEADER_YEAR_FORMAT)

    private val mListForMain = MutableLiveData<List<ApplicableForMineList>>().apply {
        value = arrayListOf()
    }

    val listForMain: LiveData<List<ApplicableForMineList>> = mListForMain

    fun fetchCurrentList() {
        repository.getList(object : CallBack<List<Record>> {
            override fun onResult(value: List<Record>) {
                rawList = ArrayList(value)
                processListRecords()
            }
        })
    }

    fun addNewRecord(systolicPressure: String, diastolicPressure: String, heartRate: String) {
        val newRecord: Record = Record(
            String(),
            null,
            systolicPressure.toInt(),
            diastolicPressure.toInt(),
            heartRate.toInt()
        )
        repository.addNewRecord(newRecord, object : CallBack<Record> {
            override fun onResult(value: Record) {
                rawList.add(0, value)
                processListRecords()
            }
        })
    }

    fun deleteRecord(record: Record) {
        repository.deleteRecord(record, object : CallBack<Any> {
            override fun onResult(value: Any) {
                value as Record
                rawList.remove(value)
                processListRecords()
            }
        })
    }

    private fun processListRecords() {
        var currentDay = String()
        var currentYear = String()
        val arrayPrepList = arrayListOf<ApplicableForMineList>()
        rawList.forEach { record ->
            record.timestamp?.let {
                val recordDate = format.format(it) ?: String()
                val recordYear = yearFormat.format(it) ?: String()
                if (currentDay == recordDate && currentYear == recordYear
                ) {
                    arrayPrepList.add(record)
                } else {
                    if (currentYear != recordYear) {
                        currentYear = recordYear
                        arrayPrepList.add(Separator(currentYear))
                    }
                    currentDay = recordDate
                    arrayPrepList.add(Separator(currentDay))
                    arrayPrepList.add(record)
                }
            }
        }
        mListForMain.postValue(arrayPrepList.toList())
    }
}