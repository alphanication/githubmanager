package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserRepoViewholderBinding

class SearchRepoByUserAdapter : ListAdapter<UserRepositoryModel, SearchRepoByUserRepoViewHolder>(
    AsyncDifferConfig.Builder(SearchRepoByUserDiffCallback()).build()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchRepoByUserRepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchRepoByUserRepoViewholderBinding.inflate(inflater, parent, false)
        return SearchRepoByUserRepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchRepoByUserRepoViewHolder, position: Int) {
        currentList.getOrNull(position)?.let { repo -> holder.bind(repo) }
    }
}