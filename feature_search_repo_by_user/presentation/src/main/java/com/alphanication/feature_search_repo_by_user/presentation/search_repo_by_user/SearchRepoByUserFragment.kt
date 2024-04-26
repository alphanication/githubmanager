package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRepoByUserFragment : Fragment() {

    private val binding: SearchRepoByUserFragmentBinding by lazy {
        SearchRepoByUserFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}