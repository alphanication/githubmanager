package com.alphanication.feature_search_repo_by_user.domain.repository

import com.alphanication.core.domain.model.ResultModel
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel

interface GitHubRemoteRepository {

    fun getReposByUsername(username: String): ResultModel<List<UserRepositoryModel>>
}