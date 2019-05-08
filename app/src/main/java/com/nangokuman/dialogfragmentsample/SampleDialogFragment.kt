package com.nangokuman.dialogfragmentsample

import android.app.Dialog
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDialogFragment

class SampleDialogFragment : AppCompatDialogFragment(){

    var title: String = "default text"

    companion object {
        @JvmStatic
        fun newInstance() =
            SampleDialogFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        dialogBuilder.setMessage(title)
            .setPositiveButton("OK"){ _, _ ->
                viewModel.inputText.set("OK done!")
            }
            .setNegativeButton("Cancel"){ _, _ ->
                viewModel.inputText.set("Cancel NG!")
            }
        return dialogBuilder.create()
    }
}
