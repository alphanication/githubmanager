package com.alphanication.feature_search_repo_by_user.data.model

import com.google.gson.annotations.SerializedName

private const val ID = "id"
private const val NODE_ID = "node_id"
private const val NAME = "name"
private const val FULL_NAME = "full_name"
private const val PRIVATE = "private"
private const val OWNER = "owner"
private const val HTML_URL = "html_url"
private const val DESCRIPTION = "description"
private const val FORK = "fork"
private const val CREATED_AT = "created_at"
private const val UPDATED_AT = "updated_at"
private const val PUSHED_AT = "pushed_at"
private const val CLONE_URL = "clone_url"
private const val SIZE = "size"
private const val STARGAZERS_COUNT = "stargazers_count"
private const val WATCHERS_COUNT = "watchers_count"
private const val LANGUAGE = "language"
private const val FORKS_COUNT = "forks_count"
private const val ARCHIVED = "archived"
private const val DISABLED = "disabled"
private const val TOPICS = "topics"

data class UserRepositoryModel(
    @SerializedName(ID)
    val id: Int,
    @SerializedName(NODE_ID)
    val nodeId: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(FULL_NAME)
    val fullName: String,
    @SerializedName(PRIVATE)
    val private: Boolean,
    @SerializedName(OWNER)
    val owner: UserRepositoryModelOwner,
    @SerializedName(HTML_URL)
    val htmlUrl: String,
    @SerializedName(DESCRIPTION)
    val description: String,
    @SerializedName(FORK)
    val fork: Boolean,
    @SerializedName(CREATED_AT)
    val createdAt: String,
    @SerializedName(UPDATED_AT)
    val updatedAt: String,
    @SerializedName(PUSHED_AT)
    val pushedAt: String,
    @SerializedName(CLONE_URL)
    val cloneUrl: String,
    @SerializedName(SIZE)
    val size: Int,
    @SerializedName(STARGAZERS_COUNT)
    val stargazersCount: Int,
    @SerializedName(WATCHERS_COUNT)
    val watchersCount: Int,
    @SerializedName(LANGUAGE)
    val language: String,
    @SerializedName(FORKS_COUNT)
    val forksCount: Int,
    @SerializedName(ARCHIVED)
    val archived: Boolean,
    @SerializedName(DISABLED)
    val disabled: Boolean,
    @SerializedName(TOPICS)
    val topics: List<String>
)