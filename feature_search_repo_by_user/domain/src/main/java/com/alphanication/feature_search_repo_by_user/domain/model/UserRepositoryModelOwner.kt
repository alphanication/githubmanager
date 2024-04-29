package com.alphanication.feature_search_repo_by_user.domain.model

data class UserRepositoryModelOwner(
    val login: String,
    val id: Int,
    val nodeId: String,
    val avatarUrl: String,
    val htmlUrl: String
)