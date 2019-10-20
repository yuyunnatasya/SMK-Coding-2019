package com.yuyunnatasya.smkcoding.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsItem(

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("video")
	val video: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("adult")
	val adult: Boolean? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
): Parcelable {
	companion object{
		const val TABLE_FAVORITE = "table_favorite"
		const val COLUMN_ID = "ID"
		const val COLUMN_POSTERPATH = "POSTERPATH"
		const val COLUMN_RATING = "RATING"
		const val COLUMN_DESCRIPTION ="DESCRIPTION"
		const val COLUMN_TITLE = "TITLE"

	}

}