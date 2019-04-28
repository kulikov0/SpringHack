package ru.rhdv.springhackapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeveloperStatistic (@Expose @SerializedName("developerPoints") val developerPoints: String,
                               @Expose @SerializedName("developerName") val developerName: String,
                               @Expose @SerializedName("developerStatus") val developerStatus: String,
                               @Expose @SerializedName("developerPhotoLink") val developerPhotoLink: String)