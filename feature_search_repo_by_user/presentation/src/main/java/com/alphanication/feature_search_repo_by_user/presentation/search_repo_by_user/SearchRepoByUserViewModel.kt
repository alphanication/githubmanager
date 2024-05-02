package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username.GetReposByUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRepoByUserViewModel @Inject constructor(
    private val getReposByUsernameUseCase: GetReposByUsernameUseCase
) : ViewModel() {

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
            Log.d("alpha33", response.data.toString())
        }
}