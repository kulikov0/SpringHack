package ru.rhdv.springhackapplication.ui.scrum_section.create_team.presenter

import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.view.CreateTeamMvpView

interface CreateTeamMvpPresenter<V: CreateTeamMvpView, I: CreateTeamMvpInteractor>: MvpPresenter<V, I> {

    fun getDevelpersList(): MutableList<AllDevelopersResponse>

}