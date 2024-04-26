package com.alphanication.githubmanager.presentation.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alphanication.githubmanager.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(binding.root)
    }
}