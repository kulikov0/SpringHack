package ru.rhdv.springhackapplication.ui.scrum_section.create_team.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.view.CreateTeamMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class CreateTeamPresenter<V: CreateTeamMvpView, I: CreateTeamMvpInteractor> @Inject constructor(interactor: I,
                                                                                                schedulerProvider: SchedulerProvider,
                                                                                                disposable: CompositeDisposable):
        BasePresenter<V, I>(interactor = interactor,schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        CreateTeamMvpPresenter<V, I> {

    override fun getDevelpersList(): MutableList<AllDevelopersResponse> = interactor?.getAvailableDevelopersList()!!

}