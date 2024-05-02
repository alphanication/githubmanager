package com.alphanication.core.presentation.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <V> Fragment.collectFlowLatest(
    collectableFlow: Flow<V>,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    actionOnCollect: suspend (value: V) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            collectableFlow.collectLatest { value ->
                actionOnCollect(value)
            }
        }
    }
}

fun <V> Fragment.collectFlow(
    collectableFlow: Flow<V>,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    actionOnCollect: suspend (value: V) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(lifecycleState) {
            collectableFlow.collect { value ->
                actionOnCollect(value)
            }
        }
    }
}