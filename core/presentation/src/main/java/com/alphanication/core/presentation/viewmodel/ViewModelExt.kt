package com.alphanication.core.presentation.viewmodel

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle

fun SavedStateHandle.withArgs(defaultArgs: Bundle): SavedStateHandle {
    for (key in defaultArgs.keySet()) {
        this[key] = defaultArgs[key]
    }
    return this
}