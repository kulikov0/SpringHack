package ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor

import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor

interface CreateTeamMvpInteractor: MvpInteractor {

    fun getAvailableDevelopersList(): MutableList<AllDevelopersResponse>

}