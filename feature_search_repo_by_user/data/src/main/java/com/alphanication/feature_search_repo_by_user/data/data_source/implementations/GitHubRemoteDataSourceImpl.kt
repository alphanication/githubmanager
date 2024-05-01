package com.alphanication.feature_search_repo_by_user.data.data_source.implementations

import com.alphanication.core.data.data_source.BaseDataSource
import com.alphanication.core.domain.model.ResultModel
import com.alphanication.feature_search_repo_by_user.data.data_source.interfaces.GitHubRemoteDataSource
import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelD
import com.alphanication.feature_search_repo_by_user.data.service.GitHubRemoteService
import javax.inject.Inject

class GitHubRemoteDataSourceImpl @Inject constructor(
    private val gitHubRemoteService: GitHubRemoteService,
) : BaseDataSource(), GitHubRemoteDataSource {

    override suspend fun getReposByUsername(username: String): ResultModel<List<UserRepositoryModelD>> =
        invokeRequest {
            gitHubRemoteService.getReposByUsername(username = username)
        }
}