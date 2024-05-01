package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

sealed interface SearchRepoByUserInteraction {

    data class SearchRepositoriesByUsername(val username: String) : SearchRepoByUserInteraction
}