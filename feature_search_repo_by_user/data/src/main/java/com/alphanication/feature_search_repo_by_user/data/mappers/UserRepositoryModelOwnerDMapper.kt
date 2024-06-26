package com.alphanication.feature_search_repo_by_user.data.mappers

import com.alphanication.core.data.mappers.MapperData
import com.alphanication.core.data.mappers.MappersExt.EMPTY_STRING
import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelOwnerD
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModelOwner

internal class UserRepositoryModelOwnerDMapper :
    MapperData<UserRepositoryModelOwnerD, UserRepositoryModelOwner?> {

    override fun mapFromEntity(type: UserRepositoryModelOwnerD): UserRepositoryModelOwner? =
        kotlin.runCatching {
            UserRepositoryModelOwner(
                login = type.login ?: throw NullPointerException("login is null"),
                id = type.id ?: throw NullPointerException("id is null"),
                nodeId = type.nodeId ?: throw NullPointerException("nodeId is null"),
                avatarUrl = type.avatarUrl ?: EMPTY_STRING,
                htmlUrl = type.htmlUrl ?: throw NullPointerException("htmlUrl is null")
            )
        }.getOrNull()
}