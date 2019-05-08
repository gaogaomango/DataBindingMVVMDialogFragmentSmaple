package com.nangokuman.dialogfragmentsample

import android.os.Bundle
import android.support.v4.app.Fragment

class ViewModelHolder<VM> : Fragment() {
    var viewModel: VM? = null

    companion object {
        fun <M> createContainer(viewModel: M): ViewModelHolder<M> {
            val viewModelContainer = ViewModelHolder<M>()
            viewModelContainer.viewModel = viewModel
            return viewModelContainer
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
}