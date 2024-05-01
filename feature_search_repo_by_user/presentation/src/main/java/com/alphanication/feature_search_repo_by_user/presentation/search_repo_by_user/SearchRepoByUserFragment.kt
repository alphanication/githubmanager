package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import android.os.Bundle
import android.view.View
import com.alphanication.core.presentation.screens.BaseFragment
import com.alphanication.core.presentation.view.afterTextChanged
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserFragmentBinding
import com.alphanication.feature_search_repo_by_user.presentation.scopes.FeatureSearchRepoByUserScope
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@FeatureSearchRepoByUserScope
@AndroidEntryPoint
class SearchRepoByUserFragment :
    BaseFragment<SearchRepoByUserViewModel, SearchRepoByUserFragmentBinding>() {

    @Inject
    override lateinit var factory: SearchRepoByUserViewModel.Factory

    override val binding: SearchRepoByUserFragmentBinding by lazy {
        SearchRepoByUserFragmentBinding.inflate(layoutInflater)
    }

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