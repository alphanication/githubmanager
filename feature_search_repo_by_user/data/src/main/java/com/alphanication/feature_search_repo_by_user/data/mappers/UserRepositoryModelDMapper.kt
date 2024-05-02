package com.alphanication.feature_search_repo_by_user.data.mappers

import com.alphanication.core.data.mappers.MapperData
import com.alphanication.core.data.mappers.MappersExt.EMPTY_STRING
import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelD
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel

internal class UserRepositoryModelDMapper : MapperData<UserRepositoryModelD, UserRepositoryModel?> {

    override fun mapFromEntity(type: UserRepositoryModelD): UserRepositoryModel? =
        kotlin.runCatching {
            UserRepositoryModel(
                id = type.id ?: throw NullPointerException("id is null"),
                nodeId = type.nodeId ?: throw NullPointerException("nodeId is null"),
                fullName = type.fullName ?: throw NullPointerException("fullName is null"),
                name = type.name ?: throw NullPointerException("name is null"),
                private = type.private ?: false,
                owner = UserRepositoryModelOwnerDMapper().mapFromEntity(
                    type.owner ?: throw NullPointerException("owner is null")
                ) ?: throw NullPointerException("owner is null"),
                htmlUrl = type.htmlUrl ?: throw NullPointerException("htmlUrl is null"),
                description = type.description ?: EMPTY_STRING,
                fork = type.fork ?: false,
                createdAt = type.createdAt ?: throw NullPointerException("createdAt is null"),
                updatedAt = type.updatedAt ?: EMPTY_STRING,
                pushedAt = type.pushedAt ?: EMPTY_STRING,
                cloneUrl = type.cloneUrl ?: throw NullPointerException("cloneUrl is null"),
                size = type.size ?: 0,
                stargazersCount = type.stargazersCount ?: 0,
                watchersCount = type.watchersCount ?: 0,
                forksCount = type.forksCount ?: 0,
                disabled = type.disabled ?: false,
                topics = type.topics ?: listOf()
            )
        }.getOrNull()
}