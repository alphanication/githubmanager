package com.alphanication.core.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelFactory<T: ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): T
}