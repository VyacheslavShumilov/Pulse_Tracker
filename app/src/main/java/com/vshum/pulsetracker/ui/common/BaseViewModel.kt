package com.vshum.pulsetracker.ui.common

import androidx.lifecycle.ViewModel
import com.vshum.pulsetracker.domain.BaseConstants
import com.vshum.pulsetracker.model.Repository

abstract class BaseViewModel : ViewModel() {
    protected val TAG = "${BaseConstants.MY_TAG} / ${this.javaClass.simpleName}"
    protected val repository = Repository()
}