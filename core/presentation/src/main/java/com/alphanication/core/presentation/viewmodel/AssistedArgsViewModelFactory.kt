package com.alphanication.core.presentation.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class AssistedArgsViewModelFactory<T : ViewModel>(
    private val factory: ViewModelFactory<T>,
    owner: SavedStateRegistryOwner,
    private val defaultArgs: Bundle
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {

        return factory.create(handle.withArgs(defaultArgs)) as? T
            ?: throw IllegalStateException("Unknown ViewModel class \'${modelClass.simpleName}\'")
    }
}