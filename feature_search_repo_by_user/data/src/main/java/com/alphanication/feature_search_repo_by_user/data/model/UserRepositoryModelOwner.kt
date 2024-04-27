package com.alphanication.feature_search_repo_by_user.data.model

import com.google.gson.annotations.SerializedName

private const val LOGIN = "login"
private const val ID = "id"
private const val NODE_ID = "node_id"
private const val AVATAR_URL = "avatar_url"
private const val HTML_URL = "html_url"

data class UserRepositoryModelOwner(
    @SerializedName(LOGIN)
    val login: String,
    @SerializedName(ID)
    val id: Int,
    @SerializedName(NODE_ID)
    val nodeId: String,
    @SerializedName(AVATAR_URL)
    val avatarUrl: String,
    @SerializedName(HTML_URL)
    val htmlUrl: String
)