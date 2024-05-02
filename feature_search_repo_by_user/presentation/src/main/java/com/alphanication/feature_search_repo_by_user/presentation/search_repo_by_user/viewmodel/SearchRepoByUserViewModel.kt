package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphanication.core.domain.model.Status
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username.GetReposByUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRepoByUserViewModel @Inject constructor(
    private val getReposByUsernameUseCase: GetReposByUsernameUseCase
) : ViewModel() {

    private val _repositories: MutableStateFlow<List<UserRepositoryModel>> = MutableStateFlow(
        listOf()
    )
    val repositories: StateFlow<List<UserRepositoryModel>> = _repositories.asStateFlow()

    fun onInteraction(action: SearchRepoByUserInteraction) {
        when (action) {
            is SearchRepoByUserInteraction.SearchRepositoriesByUsername -> searchRepositoriesByUsername(
                action
            )
        }
    }

    private fun searchRepositoriesByUsername(action: SearchRepoByUserInteraction.SearchRepositoriesByUsername) =
        viewModelScope.launch {
            val response = getReposByUsernameUseCase.invoke(username = action.username)
            when (response.status) {
                Status.SUCCESS -> response.data?.let { repo -> _repositories.update { repo } }
                Status.ERROR -> Unit
            }
        }
}