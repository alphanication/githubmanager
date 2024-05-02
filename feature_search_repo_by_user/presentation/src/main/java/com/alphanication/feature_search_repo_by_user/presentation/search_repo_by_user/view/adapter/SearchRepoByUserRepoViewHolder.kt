package com.alphanication.feature_search_repo_by_user.presentation.search_repo_by_user.view.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.alphanication.core.presentation.view.visible
import com.alphanication.feature_search_repo_by_user.domain.model.UserRepositoryModel
import com.alphanication.feature_search_repo_by_user.presentation.R
import com.alphanication.feature_search_repo_by_user.presentation.databinding.SearchRepoByUserRepoViewholderBinding
import com.google.android.material.chip.Chip
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit

private const val TIMEZONE_UTC = "UTC"
private const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"

class SearchRepoByUserRepoViewHolder(
    private val binding: SearchRepoByUserRepoViewholderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: UserRepositoryModel) = binding.apply {
        tvRepoName.text = repository.name
        tvRepoDescription.text = repository.description
            ?: root.resources.getString(R.string.search_by_user_repository_no_description)
        ivRepoStar.setImageResource(R.drawable.ic_search_by_user_star)
        tvRepoStarCount.text = repository.stargazersCount.toString()
        bindRepositoryTopics(repository)
        bindDateUpdatedAt(repository)
    }

    private fun bindDateUpdatedAt(repository: UserRepositoryModel) = kotlin.runCatching {
        val currentDate = Date()

        val sdf = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(TIMEZONE_UTC)
        val updateDate = sdf.parse(repository.updatedAt)

        val diffInMillis = currentDate.time - (updateDate?.time ?: 0)
        val daysElapsed = TimeUnit.MILLISECONDS.toDays(diffInMillis).toString()

        binding.tvRepoUpdatedAt.text = String.format(
            binding.root.resources.getString(R.string.search_by_user_repository_updated_x_days_ago),
            daysElapsed
        )
    }

    private fun bindRepositoryTopics(repository: UserRepositoryModel) = binding.apply {
        val chips = repository.topics.map { topic ->
            createTopicsChip(
                context = root.context, chipName = topic, color = R.color.chips_background
            )
        }
        chips.forEach { chip -> cgRepoTopics.addView(chip) }
        cgRepoTopics.visible(chips.isNotEmpty())
    }

    private fun createTopicsChip(context: Context, chipName: String, color: Int): Chip {
        return Chip(context).apply {
            text = chipName
            setChipBackgroundColorResource(color)
            chipStrokeWidth = 0F
            ensureAccessibleTouchTarget(0)
            minWidth = 0
            minHeight = 0
        }
    }
}