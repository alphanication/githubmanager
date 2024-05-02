package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel

class SearchRepoByUserDiffCallback : DiffUtil.ItemCallback<UserRepositoryModel>() {

    override fun areItemsTheSame(
        oldItem: UserRepositoryModel,
        newItem: UserRepositoryModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UserRepositoryModel,
        newItem: UserRepositoryModel
    ): Boolean {
        return oldItem == newItem
    }
}