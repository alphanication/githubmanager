package com.alphanication.feature_search_repo_by_user.di.modules

import com.alphanication.feature_search_repo_by_user.data.data_source.interfaces.GitHubRemoteDataSource
import com.alphanication.feature_search_repo_by_user.data.repository.GitHubRemoteRepositoryImpl
import com.alphanication.feature_search_repo_by_user.domain.repository.GitHubRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGitHubRemoteRepository(gitHubRemoteDataSource: GitHubRemoteDataSource): GitHubRemoteRepository = GitHubRemoteRepositoryImpl(gitHubRemoteDataSource = gitHubRemoteDataSource)
}