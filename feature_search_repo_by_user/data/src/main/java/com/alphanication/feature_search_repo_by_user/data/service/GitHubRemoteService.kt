package com.alphanication.feature_search_repo_by_user.data.service

import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelD
import com.alphanication.feature_search_repo_by_user.data.utils.GitHubRemoteServiceConstants.GET_REPO_BY_USERNAME
import com.alphanication.feature_search_repo_by_user.data.utils.GitHubRemoteServiceConstants.GET_REPO_BY_USERNAME_PATH_USER
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubRemoteService {

    @GET(GET_REPO_BY_USERNAME)
    suspend fun getReposByUsername(
        @Path(GET_REPO_BY_USERNAME_PATH_USER) username: String
    ): Response<List<UserRepositoryModelD>>

    companion object {
        const val GITHUB_API_URL = "https://api.github.com/"
    }
}