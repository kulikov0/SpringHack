package ru.rhdv.springhackapplication.ui.scrum_section.main.presenter

import ru.rhdv.springhackapplication.data.network.response.AllTeamsResponse
import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.main.interactor.ScrumSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.main.view.ScrumSectionMvpView

interface ScrumSectionMvpPresenter<V: ScrumSectionMvpView, I: ScrumSectionMvpInteractor>: MvpPresenter<V, I> {
    fun getAllTeans(): MutableList<AllTeamsResponse>
}