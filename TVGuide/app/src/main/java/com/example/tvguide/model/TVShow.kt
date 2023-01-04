package com.example.tvguide.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVShow (
    val backdrop_path: String = "",
    val id: Int = 0,
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Float = 0f,
    val poster_path: String = "",
    val name: String = "",
    val first_air_date: String = "",
    val vote_average: Float = 0f,
    val vote_count: Int = 0
): Parcelable