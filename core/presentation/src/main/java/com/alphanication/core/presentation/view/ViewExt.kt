package com.alphanication.core.presentation.view

import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

inline fun TextInputEditText.onTextChanged(
    crossinline onTextChanged: (string: CharSequence) -> Unit,
): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) = Unit

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) =
            onTextChanged(s)
    }
    addTextChangedListener(textWatcher)
    return textWatcher
}

inline fun EditText.afterTextChanged(
    crossinline afterTextChanged: (string: Editable) -> Unit,
): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) = afterTextChanged(s)

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit
    }
    addTextChangedListener(textWatcher)
    return textWatcher
}

inline fun View.onClick(delayMillis: Long = 500, crossinline clickListener: (View) -> Unit) {
    var clickMillis = 0L
    setOnClickListener {
        val elapsedRealTime = SystemClock.elapsedRealtime()
        if (elapsedRealTime > clickMillis) {
            clickMillis = elapsedRealTime + delayMillis
            clickListener.invoke(it)
        }
    }
}

inline fun View.onLongClick(delayMillis: Long = 500, crossinline clickListener: (View) -> Unit) {
    var clickMillis = 0L
    setOnLongClickListener {
        val elapsedRealTime = SystemClock.elapsedRealtime()
        if (elapsedRealTime > clickMillis) {
            clickMillis = elapsedRealTime + delayMillis
            clickListener.invoke(it)
        }
        true
    }
}