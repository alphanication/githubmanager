package com.alphanication.feature_search_repo_by_user.di.components

import com.alphanication.feature_search_repo_by_user.di.modules.DataModule
import com.alphanication.feature_search_repo_by_user.di.modules.DomainModule
import com.alphanication.feature_search_repo_by_user.presentation.scopes.FeatureSearchRepoByUserScope
import dagger.Component

@FeatureSearchRepoByUserScope
@Component(
    modules = [
        DataModule::class,
        DomainModule::class
    ]
)
class FeatureSearchRepoByUserComponent