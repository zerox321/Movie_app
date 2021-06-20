package com.example.moveApp.ui.home.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.moveApp.R
import com.example.moveApp.core.BaseFragment
import com.example.moveApp.databinding.MenuDetailsFragmentBinding
import com.example.moveApp.util.NavigationUtil.findNavigationController
import com.example.moveApp.util.NavigationUtil.popStack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuDetailsFragment :
    BaseFragment<MenuDetailsFragmentBinding>(R.layout.menu_details_fragment) {
    private val args: MenuDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            toolbar.setNavigationOnClickListener { v -> v.findNavigationController().popStack() }
            item = this@MenuDetailsFragment.args.Item
        }.root
    }


}