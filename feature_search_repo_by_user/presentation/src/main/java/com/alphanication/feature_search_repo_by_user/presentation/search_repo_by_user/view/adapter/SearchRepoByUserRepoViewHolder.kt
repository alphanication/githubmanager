package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserRepoViewholderBinding

class SearchRepoByUserRepoViewHolder(
    private val binding: SearchRepoByUserRepoViewholderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: UserRepositoryModel) = binding.apply {
        tvRepoName.text = repository.name
    }
}