package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphanication.core.presentation.viewmodel.ViewModelFactory
import com.alphanication.feature_search_repo_by_user.domain.use_case.get_repos_by_username.GetReposByUsernameUseCase
import com.alphanication.feature_search_repo_by_user.presentation.scopes.FeatureSearchRepoByUserScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class SearchRepoByUserViewModel @AssistedInject constructor(
    private val getReposByUsernameUseCase: GetReposByUsernameUseCase,
    @Assisted savedStateHandle: SavedStateHandle,
) : ViewModel() {

    @AssistedFactory
    interface Factory : ViewModelFactory<SearchRepoByUserViewModel>

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