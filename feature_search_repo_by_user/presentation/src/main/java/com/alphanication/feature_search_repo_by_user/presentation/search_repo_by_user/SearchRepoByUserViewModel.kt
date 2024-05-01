package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alphanication.core.presentation.viewmodel.ViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SearchRepoByUserViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
) : ViewModel() {

    @AssistedFactory
    interface Factory : ViewModelFactory<SearchRepoByUserViewModel>
}