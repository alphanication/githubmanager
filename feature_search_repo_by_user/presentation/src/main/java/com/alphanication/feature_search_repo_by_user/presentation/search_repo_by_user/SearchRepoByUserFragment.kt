package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alphanication.core.presentation.screens.BaseFragment
import com.alphanication.core.presentation.view.afterTextChanged
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRepoByUserFragment :
    BaseFragment<SearchRepoByUserViewModel, SearchRepoByUserFragmentBinding>() {

    override val binding: SearchRepoByUserFragmentBinding by lazy {
        SearchRepoByUserFragmentBinding.inflate(layoutInflater)
    }

    override val viewModel: SearchRepoByUserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewListeners()
    }

    private fun setupViewListeners() = binding.apply {
        etUsername.afterTextChanged { text ->
            viewModel.onInteraction(
                SearchRepoByUserInteraction.SearchRepositoriesByUsername(
                    username = text.toString()
                )
            )
        }
    }
}