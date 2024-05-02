package com.alphanication.feature_search_repo_by_user.data.data_source.interfaces

import com.alphanication.core.domain.model.ResultModel
import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelD

interface GitHubRemoteDataSource {

    suspend fun getReposByUsername(username: String): ResultModel<List<UserRepositoryModelD>>
}