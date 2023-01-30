package com.vshum.pulsetracker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainDataSeparatorViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListDataSeparatorBinding = ItemListDataSeparatorBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvDate
}