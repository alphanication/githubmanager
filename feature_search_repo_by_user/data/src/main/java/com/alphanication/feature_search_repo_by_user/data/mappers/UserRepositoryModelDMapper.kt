package com.alphanication.feature_search_repo_by_user.data.mappers

import com.alphanication.core.data.mappers.MapperData
import com.alphanication.feature_search_repo_by_user.data.model.UserRepositoryModelD
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel

internal class UserRepositoryModelDMapper : MapperData<UserRepositoryModelD, UserRepositoryModel> {

    override fun mapFromEntity(type: UserRepositoryModelD): UserRepositoryModel {
        return UserRepositoryModel(
            id = type.id ?: throw NullPointerException("id is null"),
            nodeId = type.nodeId ?: throw NullPointerException("nodeId is null"),
            fullName = type.fullName ?: throw NullPointerException("fullName is null"),
            name = type.name ?: throw NullPointerException("name is null"),
            private = type.private ?: throw NullPointerException("private is null"),
            owner = UserRepositoryModelOwnerDMapper().mapFromEntity(
                type.owner ?: throw NullPointerException("null suck")
            ),
//                    owner = when (val result =
//                        UserRepositoryModelOwnerDMapper().mapFromEntity(type.owner ?: throw NullPointerException("null suck"))) {
//                        is MapResult.NullPointerException -> throw result.exception
//                        is MapResult.Data -> result.data
//                        else -> throw NullPointerException("suck")
//                    },
            htmlUrl = type.htmlUrl ?: throw NullPointerException("htmlUrl is null"),
            description = type.description
                ?: throw NullPointerException("description is null"),
            fork = type.fork ?: throw NullPointerException("fork is null"),
            createdAt = type.createdAt ?: throw NullPointerException("createdAt is null"),
            updatedAt = type.updatedAt ?: throw NullPointerException("updatedAt is null"),
            pushedAt = type.pushedAt ?: throw NullPointerException("pushedAt is null"),
            cloneUrl = type.cloneUrl ?: throw NullPointerException("cloneUrl is null"),
            size = type.size ?: throw NullPointerException("size is null"),
            stargazersCount = type.stargazersCount
                ?: throw NullPointerException("stargazersCount is null"),
            watchersCount = type.watchersCount
                ?: throw NullPointerException("watchersCount is null"),
            forksCount = type.forksCount
                ?: throw NullPointerException("forksCount is null"),
            disabled = type.disabled ?: throw NullPointerException("disabled is null"),
            topics = type.topics ?: throw NullPointerException("topics is null")
        )
    }
}