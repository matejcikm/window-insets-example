package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.core.content.res.use
import androidx.core.view.doOnLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding>(
    @LayoutRes val layoutId: Int
) : Fragment() {

    protected lateinit var binding: B

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                LayoutInflater.from(requireContext()),
                layoutId,
                container,
                false
            )
        setStatusBarFromTheme(binding.root)
        return binding.root
    }

    private fun setStatusBarFromTheme(view: View) {
        view.context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.windowLightStatusBar))
            .use { typedArray ->
                val isLightStatusBar = typedArray.getBoolean(0, false)

                requireActivity().window.decorView.doOnLayout {
                    setLightOrDarkStatusBar(isLightStatusBar)
                }
                setLightOrDarkStatusBar(isLightStatusBar)
            }
    }

    private fun setLightOrDarkStatusBar(isLight: Boolean) {
        if (isLight) {
            setLightStatusBar()
        } else {
            clearLightStatusBar()
        }
    }

    private fun setLightStatusBar() {
        var flags = requireActivity().window.decorView.systemUiVisibility // get current flag
        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // add LIGHT_STATUS_BAR to flag
        requireActivity().window.decorView.systemUiVisibility = flags
    }

    private fun clearLightStatusBar() {
        var flags = requireActivity().window.decorView.systemUiVisibility // get current flag
        flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // use XOR here for remove LIGHT_STATUS_BAR from flags
        requireActivity().window.decorView.systemUiVisibility = flags
    }
}
