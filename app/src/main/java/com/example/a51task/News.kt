package com.example.a51task

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val imageUrl: String,
    val description: String,
    val related: List<News> = emptyList()
) : Parcelable
