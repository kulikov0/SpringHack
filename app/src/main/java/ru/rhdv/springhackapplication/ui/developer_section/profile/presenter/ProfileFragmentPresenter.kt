package ru.rhdv.springhackapplication.ui.developer_section.profile.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.developer_section.profile.interactor.ProfileFragmentMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.profile.view.ProfileFragmentMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class ProfileFragmentPresenter<V: ProfileFragmentMvpView, I: ProfileFragmentMvpInteractor> @Inject constructor(interactor: I,
                                                                                                               schedulerProvider: SchedulerProvider,
                                                                                                               disposable: CompositeDisposable):
        BasePresenter<V,I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        ProfileFragmentMvpPresenter<V, I>