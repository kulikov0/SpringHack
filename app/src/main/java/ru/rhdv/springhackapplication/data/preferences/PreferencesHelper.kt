package ru.rhdv.springhackapplication.data.preferences


interface PreferencesHelper {

    fun clearAll()
    fun setAccessTokenFromServer(accessToken: String?)
    fun getAccessToken(): String?
}