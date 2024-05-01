package com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username

import com.alphanication.core.domain.model.ResultModel
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.domain.repository.GitHubRemoteRepository

class DefaultGetReposByUsernameUseCase(
    private val gitHubRemoteRepository: GitHubRemoteRepository,
) : GetReposByUsernameUseCase {

    override suspend fun invoke(username: String): ResultModel<List<UserRepositoryModel>> {
        return gitHubRemoteRepository.getReposByUsername(username = username)
    }
}