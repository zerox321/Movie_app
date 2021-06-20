package com.example.moveApp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.datalayer.model.Movie
import com.example.moveApp.BuildConfig
import com.example.moveApp.R
import com.example.moveApp.core.BaseFragment
import com.example.moveApp.databinding.FragmentMainBinding
import com.example.moveApp.ui.home.adapter.MenuClickListener
import com.example.moveApp.ui.home.adapter.MovieAdapter
import com.example.moveApp.util.NavigationUtil.findNavigationController
import com.example.moveApp.util.NavigationUtil.navigateTo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main),
    MenuClickListener {

    private val viewModel by viewModels<MainViewModel>()
    private val popularAdapter: MovieAdapter = MovieAdapter(this)
    private val topRatedAdapter: MovieAdapter = MovieAdapter(this)
    private val upComingAdapter: MovieAdapter = MovieAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            viewModel = this@MainFragment.viewModel
            popularAdapter = this@MainFragment.popularAdapter
            topRatedAdapter = this@MainFragment.topRatedAdapter
            upComingAdapter = this@MainFragment.upComingAdapter
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo observe Movies response
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.popularFlow.collect { response -> popularAdapter.submitData(response) }
        }
        popularAdapter.addLoadStateListener { state ->
            when (state.refresh) {
                is LoadState.Loading -> viewModel.setPopularLoading(isLoading = true)
                is LoadState.Error -> {
                }
                is LoadState.NotLoading -> viewModel.setPopularLoading(isLoading = false)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.topRatedFlow.collect { response -> topRatedAdapter.submitData(response) }
        }
        topRatedAdapter.addLoadStateListener { state ->
            when (state.refresh) {
                is LoadState.Loading -> viewModel.setTopRatedLoading(isLoading = true)
                is LoadState.Error -> {
                }
                is LoadState.NotLoading -> viewModel.setTopRatedLoading(isLoading = false)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.upComingFlow.collect { response -> upComingAdapter.submitData(response) }
        }
        upComingAdapter.addLoadStateListener { state ->
            when (state.refresh) {
                is LoadState.Loading -> viewModel.setUpComingLoadingLoading(isLoading = true)
                is LoadState.Error -> {
                }
                is LoadState.NotLoading -> viewModel.setUpComingLoadingLoading(isLoading = false)
            }
        }
    }

    private fun onError(throwable: Throwable) {

        val errorMessage = if (BuildConfig.DEBUG) "${throwable.message}"
        else context?.getString(R.string.no_internet)

        Toast.makeText(context ?: return, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(v: View, item: Movie) {
        val args = Bundle().apply {
            putParcelable("Item", item)
            putString("title", item.title)
        }
        v.findNavigationController()
            .navigateTo(id = R.id.action_MenuFragment_to_MovieDetailsFragment, args = args)
    }


}