package com.alphanication.core.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.alphanication.core.presentation.viewmodel.AssistedArgsViewModelFactory
import com.alphanication.core.presentation.viewmodel.ViewModelFactory

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding>() : Fragment() {

    abstract val binding: VB

    protected val viewModel: VM by assistedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    abstract val factory: ViewModelFactory<out VM>

    private fun <VM> assistedViewModel(
    ): Lazy<VM> =
        viewModels(ownerProducer = { this }, factoryProducer = {
            AssistedArgsViewModelFactory(factory, this, arguments ?: Bundle.EMPTY)
        })
}