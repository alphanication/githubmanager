package com.alphanication.feature_search_repo_by_user.data.repository

import com.alphanication.core.domain.model.ResultModel
import com.alphanication.feature_search_repo_by_user.data.data_source.interfaces.GitHubRemoteDataSource
import com.alphanication.feature_search_repo_by_user.data.mappers.UserRepositoryModelDMapper
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.domain.repository.GitHubRemoteRepository
import javax.inject.Inject

class GitHubRemoteRepositoryImpl(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource,
) : GitHubRemoteRepository {

    override suspend fun getReposByUsername(username: String): ResultModel<List<UserRepositoryModel>> {
        val response = gitHubRemoteDataSource.getReposByUsername(username = username)
        return ResultModel(
            status = response.status,
            data = response.data?.map { model -> UserRepositoryModelDMapper().mapFromEntity(model) },
            errorThrowable = response.errorThrowable
        )
    }
}