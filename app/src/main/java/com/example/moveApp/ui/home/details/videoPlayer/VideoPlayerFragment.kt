package com.example.moveApp.ui.home.details.videoPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.moveApp.R
import com.example.moveApp.binding.loadVideoPlayer
import com.example.moveApp.core.BaseFragment
import com.example.moveApp.databinding.FragmentVideoPlayerBinding
import com.example.moveApp.ui.home.details.MenuDetailsFragmentArgs


class VideoPlayerFragment :
    BaseFragment<FragmentVideoPlayerBinding>(R.layout.fragment_video_player) {
    private val args: VideoPlayerFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycle.addObserver(player)
            player.loadVideoPlayer(args.key)
        }.root
    }

}