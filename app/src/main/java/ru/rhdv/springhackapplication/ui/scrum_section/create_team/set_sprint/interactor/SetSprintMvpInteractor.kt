package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor

import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor

interface SetSprintMvpInteractor: MvpInteractor {

    fun getAvailableTasks(): MutableList<AvailableTasksResponse>

}