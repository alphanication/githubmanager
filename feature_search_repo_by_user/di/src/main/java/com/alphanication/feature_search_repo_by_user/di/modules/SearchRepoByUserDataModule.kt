package com.alphanication.feature_search_repo_by_user.di.modules

import com.alphanication.feature_search_repo_by_user.data.data_source.implementations.GitHubRemoteDataSourceImpl
import com.alphanication.feature_search_repo_by_user.data.data_source.interfaces.GitHubRemoteDataSource
import com.alphanication.feature_search_repo_by_user.data.service.GitHubRemoteService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val DEFAULT_HTTP_REQUEST_TIMEOUT = 5L

@Module
@InstallIn(SingletonComponent::class)
internal object SearchRepoByUserDataModule {

    private fun createRetrofitClient(
        baseUrl: String, okHttpClient: OkHttpClient, gson: Gson,
    ): Retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson)).build()

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(DEFAULT_HTTP_REQUEST_TIMEOUT, TimeUnit.MINUTES)
        .writeTimeout(DEFAULT_HTTP_REQUEST_TIMEOUT, TimeUnit.MINUTES)
        .readTimeout(DEFAULT_HTTP_REQUEST_TIMEOUT, TimeUnit.MINUTES)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).build()

    private fun provideGson(): Gson = GsonBuilder().setLenient().serializeNulls().create()

    @Provides
    @Singleton
    fun provideGitHubRemoteService(): GitHubRemoteService = createRetrofitClient(
        baseUrl = GitHubRemoteService.GITHUB_API_URL,
        okHttpClient = provideOkHttpClient(),
        provideGson()
    ).create(GitHubRemoteService::class.java)

    @Provides
    @Singleton
    fun provideGitHubRemoteDataSource(gitHubRemoteService: GitHubRemoteService): GitHubRemoteDataSource =
        GitHubRemoteDataSourceImpl(gitHubRemoteService = gitHubRemoteService)
}