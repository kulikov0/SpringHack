package ru.rhdv.springhackapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllDevelopersResponse(@Expose @SerializedName("developerId") val developerId: Int? = null,
                                 @Expose @SerializedName("developerName") val developerName: String? = null,
                                 @Expose @SerializedName("developerStatus") val developerStatus: String? = null,
                                 @Expose @SerializedName("developerPhotoLink") val developerPhotoLink: String? = null)