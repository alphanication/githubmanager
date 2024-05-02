package com.alphanicationfeature_downloads_repo.presentation.downloads_repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alphanicationfeature_downloads_repo.presentation.databinding.DownloadsRepoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DownloadsRepoFragment : Fragment() {

    private val binding: DownloadsRepoFragmentBinding by lazy {
        DownloadsRepoFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}