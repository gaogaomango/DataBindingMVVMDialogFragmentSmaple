package com.nangokuman.dialogfragmentsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nangokuman.dialogfragmentsample.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var viewModel: MainViewModel? = null

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {
                    //                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val binding = FragmentMainBinding.bind(view) as FragmentMainBinding
        binding.viewModel = viewModel
        binding.viewModel?.inputText?.set("default text")
        return view
    }

}
