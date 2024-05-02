package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphanication.core.presentation.screens.BaseFragment
import com.alphanication.core.presentation.view.afterTextChanged
import com.alphanication.core.presentation.view.collectFlowLatest
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserFragmentBinding
import com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view.adapter.SearchRepoByUserAdapter
import com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.viewmodel.SearchRepoByUserInteraction
import com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.viewmodel.SearchRepoByUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRepoByUserFragment :
    BaseFragment<SearchRepoByUserViewModel, SearchRepoByUserFragmentBinding>() {

    override val binding: SearchRepoByUserFragmentBinding by lazy {
        SearchRepoByUserFragmentBinding.inflate(layoutInflater)
    }

    override val viewModel: SearchRepoByUserViewModel by viewModels()

    private val repositoriesAdapter by lazy { SearchRepoByUserAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewListeners()
        setupViewModelListeners()
    }

    private fun setupView() = binding.apply {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvRepositories.layoutManager = linearLayoutManager
        rvRepositories.adapter = repositoriesAdapter
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

    private fun setupViewModelListeners() = viewModel.apply {
        collectFlowLatest(repositories) { repo ->
            repositoriesAdapter.submitList(repo)
        }
    }
}