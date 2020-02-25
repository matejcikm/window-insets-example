package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val navArgs by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.item = navArgs.item
        binding.executePendingBindings()

        sharedElementEnterTransition = MaterialContainerTransform(requireContext())
        sharedElementReturnTransition = MaterialContainerTransform(requireContext())
    }
}
