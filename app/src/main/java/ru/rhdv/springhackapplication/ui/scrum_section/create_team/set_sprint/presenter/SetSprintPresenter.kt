package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor.SetSprintMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view.SetSprintMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class SetSprintPresenter<V: SetSprintMvpView, I: SetSprintMvpInteractor> @Inject constructor(interactor: I,
                                                                                             schedulerProvider: SchedulerProvider,
                                                                                             disposable: CompositeDisposable):
        BasePresenter<V,I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        SetSprintMvpPresenter<V, I> {


    override fun getAvailableTasks(): MutableList<AvailableTasksResponse> = interactor?.getAvailableTasks()!!

}