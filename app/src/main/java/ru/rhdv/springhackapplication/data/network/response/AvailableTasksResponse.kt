package ru.rhdv.springhackapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AvailableTasksResponse(@Expose @SerializedName("id") val id: Int,
                                  @Expose @SerializedName("taskName") val taskName: String? = null)