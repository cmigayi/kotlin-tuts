package com.example.kotlinmvvmdatabindingmovieapp.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movies",  primaryKeys = [("id")])
data class Movie (
    var adult: Boolean = false,
    var backdrop_path: String = "",
    var id: Int = 0,
    var original_language: String = "",
    var original_title: String = "",
    var overview: String = "",
    var popularity: Float = 0f,
    var poster_path: String = "",
    var release_date: String = "",
    var title: String = "",
    var video: Boolean = false,
    var vote_average: Float = 0f,
    var vote_count: Int = 0
): Parcelable