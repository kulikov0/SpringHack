package ru.rhdv.springhackapplication.ui.scrum_section.main.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.data.network.response.AllTeamsResponse
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.scrum_section.main.interactor.ScrumSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.main.view.ScrumSectionMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class ScrumSectionPresenter<V: ScrumSectionMvpView, I: ScrumSectionMvpInteractor> @Inject constructor(interactor: I,
                                                                                                      schedulerProvider: SchedulerProvider,
                                                                                                      disposable: CompositeDisposable):
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        ScrumSectionMvpPresenter<V,I> {

    override fun getAllTeans(): MutableList<AllTeamsResponse> = interactor?.getAllTeams()!!

}