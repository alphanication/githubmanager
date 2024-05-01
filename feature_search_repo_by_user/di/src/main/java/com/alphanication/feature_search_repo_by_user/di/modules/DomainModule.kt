package com.alphanication.feature_search_repo_by_user.di.modules

import com.alphanication.feature_search_repo_by_user.data.data_source.interfaces.GitHubRemoteDataSource
import com.alphanication.feature_search_repo_by_user.data.repository.GitHubRemoteRepositoryImpl
import com.alphanication.feature_search_repo_by_user.domain.repository.GitHubRemoteRepository
import com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username.DefaultGetReposByUsernameUseCase
import com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username.GetReposByUsernameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DomainModule {

    @Provides
    @Singleton
    fun provideGitHubRemoteRepository(gitHubRemoteDataSource: GitHubRemoteDataSource): GitHubRemoteRepository =
        GitHubRemoteRepositoryImpl(gitHubRemoteDataSource = gitHubRemoteDataSource)

    @Provides
    @Singleton
    fun provideGetReposByUsernameUseCase(gitHubRemoteRepository: GitHubRemoteRepository): GetReposByUsernameUseCase =
        DefaultGetReposByUsernameUseCase(gitHubRemoteRepository = gitHubRemoteRepository)
}