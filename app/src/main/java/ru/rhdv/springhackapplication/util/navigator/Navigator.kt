package ru.rhdv.springhackapplication.util.navigator
import android.content.Intent

interface Navigator {

    fun makeToast(toast: String)
    fun openLoginScreen()
    fun openDeveloperSection()
    fun openCreateTeamScreen()
    fun openScrumSectionScreen()
    fun openSetSprintScreen()
}