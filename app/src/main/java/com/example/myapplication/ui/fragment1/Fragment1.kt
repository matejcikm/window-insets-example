package com.example.myapplication.ui.fragment1

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.Fragment1Binding
import com.example.myapplication.model.SampleItem
import com.example.myapplication.ui.BaseFragment
import com.google.android.material.transition.Hold
import java.util.concurrent.TimeUnit
import androidx.core.view.doOnNextLayout

class Fragment1 : BaseFragment<Fragment1Binding>(R.layout.fragment_1) {

    private val adapter: Fragment1Adapter by lazy { Fragment1Adapter(navigation) }

    private val navigation: (view: View, item: SampleItem) -> Unit = { clickedView, item ->
        val extras = FragmentNavigatorExtras(clickedView to "shared_element_container")
        findNavController().navigate(Fragment1Directions.navigateToDetail(item), extras)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.apply {
            adapter = this@Fragment1.adapter
            this@Fragment1.adapter.submitList(SampleItem.DATA)
            doOnNextLayout {
                startPostponedEnterTransition()
            }

        }
        exitTransition = Hold()
        postponeEnterTransition(1000, TimeUnit.MILLISECONDS)
    }
}

