package com.alphanication.feature_search_repo_by_user.domain.model

data class UserRepositoryModel(
    val id: Int,
    val nodeId: String,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val owner: UserRepositoryModelOwner,
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val pushedAt: String,
    val cloneUrl: String,
    val size: Int,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val disabled: Boolean,
    val topics: List<String>
)