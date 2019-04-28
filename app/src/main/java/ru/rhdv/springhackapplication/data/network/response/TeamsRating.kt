package ru.rhdv.springhackapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TeamsRating(@Expose @SerializedName("teamName") val teamName: String,
                       @Expose @SerializedName("teamPhoto") val teamPhoto: String,
                       @Expose @SerializedName("teamAvailable") val teamRating: String)