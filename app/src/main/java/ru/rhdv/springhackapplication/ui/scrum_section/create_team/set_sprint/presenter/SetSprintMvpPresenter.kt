package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.presenter

import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor.SetSprintMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view.SetSprintMvpView

interface SetSprintMvpPresenter<V: SetSprintMvpView, I: SetSprintMvpInteractor>: MvpPresenter<V,I> {

    fun getAvailableTasks(): MutableList<AvailableTasksResponse>

}