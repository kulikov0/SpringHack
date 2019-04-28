package ru.rhdv.springhackapplication.ui.developer_section.main.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.developer_section.main.interactor.DevelopersSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.main.view.DevelopersSectionMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class DevelopersSectionPresenter<V: DevelopersSectionMvpView, I: DevelopersSectionMvpInteractor> @Inject constructor(
    interactor: I, disposable: CompositeDisposable, schedulerProvider: SchedulerProvider
): BasePresenter<V, I> (interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        DevelopersSectionMvpPresenter<V, I>