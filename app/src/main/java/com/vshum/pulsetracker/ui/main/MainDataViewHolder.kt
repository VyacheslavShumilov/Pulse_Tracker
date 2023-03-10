package com.vshum.pulsetracker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vshum.pulsetracker.databinding.ItemListRecordBinding

class MainDataViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListRecordBinding = ItemListRecordBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var time = binding.tvTime
    var systolicPressure = binding.tvPressureSystolic
    var diastolicPressure = binding.tvPressureDiastolic
    var heartRate = binding.tvHeartRate
    var card = binding.clContainer
}