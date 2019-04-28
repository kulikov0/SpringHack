package ru.rhdv.springhackapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllTeamsResponse(@Expose @SerializedName("id") val id: Int? = null,
                            @Expose @SerializedName("teamName") val teamName: String? = null,
                            @Expose @SerializedName("teamPhoto") val teamPhoto: String? = null,
                            @Expose @SerializedName("teamAvailable") val teamAvailable: Boolean? = null)