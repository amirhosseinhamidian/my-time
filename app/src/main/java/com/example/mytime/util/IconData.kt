package com.example.mytime.util

import com.example.mytime.R
import com.example.mytime.domain.model.Icon

object IconData {
    fun getData() : List<Icon>  {
        return listOf(
            Icon(1, R.drawable.ic_bar_in_pool),
            Icon(2, R.drawable.ic_coding),
            Icon(3, R.drawable.ic_finance),
            Icon(4, R.drawable.ic_coding_2),
            Icon(5, R.drawable.ic_github),
            Icon(6, R.drawable.ic_gitlab),
            Icon(7, R.drawable.ic_editing_image),
            Icon(8, R.drawable.ic_idea),
            Icon(9, R.drawable.ic_meeting),
            Icon(10, R.drawable.ic_mic),
            Icon(11, R.drawable.ic_microphone_recorder),
            Icon(12, R.drawable.ic_money),
            Icon(13, R.drawable.ic_pool),
            Icon(14, R.drawable.ic_pool_dive),
            Icon(15, R.drawable.ic_programming),
            Icon(16, R.drawable.ic_soccer),
            Icon(17, R.drawable.ic_sound_wave),
            Icon(18, R.drawable.ic_stack_overflow),
            Icon(19, R.drawable.ic_video_player),
            Icon(20, R.drawable.ic_writing_note),
            Icon(21, R.drawable.ic_youtube),
        )
    }
}