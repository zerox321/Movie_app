package com.example.moveApp.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.facebook.shimmer.ShimmerFrameLayout


@BindingAdapter("bindShimmer")
fun ShimmerFrameLayout.bindShimmer(isLoading: Boolean) {
    visibility = if (isLoading) {
        startShimmer()
        View.VISIBLE
    } else {
        stopShimmer()
        View.INVISIBLE
    }

}


