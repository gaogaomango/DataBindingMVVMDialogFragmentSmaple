package com.nangokuman.dialogfragmentsample

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel: ViewModel() {
    var inputText = ObservableField<String>()

    var mainNavigator: MainNavigator? = null

    fun onClickShowDialogFragment() {
        mainNavigator?.showSampleDialog()
    }
}