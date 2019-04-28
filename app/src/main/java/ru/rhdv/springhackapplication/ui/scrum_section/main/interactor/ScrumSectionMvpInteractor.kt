package ru.rhdv.springhackapplication.ui.scrum_section.main.interactor

import ru.rhdv.springhackapplication.data.network.response.AllTeamsResponse
import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor

interface ScrumSectionMvpInteractor: MvpInteractor {

    fun getAllTeams(): MutableList<AllTeamsResponse>

}