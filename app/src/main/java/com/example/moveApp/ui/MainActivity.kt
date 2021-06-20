package com.example.moveApp.ui

import android.os.Bundle
import com.example.moveApp.R
import com.example.moveApp.core.BaseActivity
import com.example.moveApp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    private fun bindView() {
        Timber.tag(TAG).e(" bindView start ")
        binding.run {}
    }

}