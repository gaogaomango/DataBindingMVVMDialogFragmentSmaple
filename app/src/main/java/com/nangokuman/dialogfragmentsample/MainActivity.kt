package com.nangokuman.dialogfragmentsample

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class MainActivity : AppCompatActivity(), MainNavigator {
    companion object {
        @JvmStatic
        val MAIN_VIEWMODEL_TAG = "MAIN_VIEWMODEL_TAG"
        val MAIN_SAMPLE_DIALOG_TAG = "MAIN_SAMPLE_DIALOG_TAG"
    }

    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = findOrCreateViewFragment()
        mainViewModel = findOrCreateViewModel()
        mainViewModel?.mainNavigator = this

        mainFragment.viewModel = mainViewModel
    }

    private fun findOrCreateViewFragment(): MainFragment {
        var mainFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as? MainFragment

        if(mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            addFragmentToActivity(supportFragmentManager, mainFragment, R.id.contentFrame)
        }
        return mainFragment
    }

    private fun findOrCreateViewModel(): MainViewModel {
        val retainedViewModel = supportFragmentManager.findFragmentByTag(MAIN_VIEWMODEL_TAG) as? ViewModelHolder<MainViewModel>

        return retainedViewModel?.viewModel ?: run {
            val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            addFragmentToActivity(supportFragmentManager, ViewModelHolder.createContainer(viewModel), MAIN_VIEWMODEL_TAG)
            viewModel
        }
    }

    override fun showSampleDialog() {
        val dialog = SampleDialogFragment.newInstance()
        dialog.show(supportFragmentManager, MAIN_SAMPLE_DIALOG_TAG)
    }

}

fun addFragmentToActivity(fm: FragmentManager?, fr: Fragment?, frameId: Int) {
    val tr = fm?.beginTransaction()
    fr?.let {
        tr?.add(frameId, it)
        tr?.commit()
    }
}


fun addFragmentToActivity(fm: FragmentManager?, fr: Fragment?, tag: String) {
    val tr = fm?.beginTransaction()
    fr?.let {
        tr?.add(it, tag)
        tr?.commit()
    }
}