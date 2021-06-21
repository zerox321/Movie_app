package com.example.moveApp.ui.home.details

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.datalayer.model.Movie
import com.example.datalayer.model.MovieVideo
import com.example.moveApp.R
import com.example.moveApp.core.BaseFragment
import com.example.moveApp.core.BaseResponse
import com.example.moveApp.databinding.MenuDetailsFragmentBinding
import com.example.moveApp.ui.home.details.adapter.MovieVideoAdapter
import com.example.moveApp.ui.home.details.adapter.MovieVideoClickListener
import com.example.moveApp.util.NavigationUtil.findNavigationController
import com.example.moveApp.util.NavigationUtil.navigateTo
import com.example.moveApp.util.NavigationUtil.popStack
import com.example.moveApp.util.StateFlowObserver.nonNullFlowObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuDetailsFragment :
    BaseFragment<MenuDetailsFragmentBinding>(R.layout.menu_details_fragment),
    MovieVideoClickListener {

    private val args: MenuDetailsFragmentArgs by navArgs()

    private val viewModel by viewModels<MovieDetailsViewModel>()
    private val movieVideoAdapter = MovieVideoAdapter(movieVideoClickListener = this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            toolbar.setNavigationOnClickListener { v -> v.findNavigationController().popStack() }
            viewModel = this@MenuDetailsFragment.viewModel
            item = this@MenuDetailsFragment.args.Item
            movieVideoAdapter = this@MenuDetailsFragment.movieVideoAdapter
        }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo observe Videos response
        nonNullFlowObserver(
            scope = viewLifecycleOwner.lifecycleScope,
            flow = viewModel.response,
            result = { response ->
                when (response) {
                    is BaseResponse.Loading -> viewModel.setLoading(response.loading)
                    is BaseResponse.Success -> movieVideoAdapter.submitList(response.data.results)
                    is BaseResponse.Error -> { }
                }
            }
        )
    }

    override fun onItemClick(v: View, item: MovieVideo) {

        val args = Bundle().apply {
            putString("key", item.key)
            putString("title", args.title)
        }
        v.findNavigationController()
            .navigateTo(id = R.id.action_MovieDetailsFragment_to_VideoPlayerFragment, args = args)
    }


}