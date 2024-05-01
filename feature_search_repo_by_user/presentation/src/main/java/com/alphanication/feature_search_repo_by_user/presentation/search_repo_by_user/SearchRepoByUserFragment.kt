package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import com.alphanication.core.presentation.screens.BaseFragment
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchRepoByUserFragment :
    BaseFragment<SearchRepoByUserViewModel, SearchRepoByUserFragmentBinding>() {

    @Inject
    override lateinit var factory: SearchRepoByUserViewModel.Factory

    override val binding: SearchRepoByUserFragmentBinding by lazy {
        SearchRepoByUserFragmentBinding.inflate(layoutInflater)
    }
}