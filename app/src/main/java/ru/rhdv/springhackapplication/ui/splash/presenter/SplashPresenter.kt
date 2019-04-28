package ru.rhdv.springhackapplication.ui.splash.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.ui.base.presenter.BasePresenter
import ru.rhdv.springhackapplication.ui.splash.interactor.SplashMvpInteractor
import ru.rhdv.springhackapplication.ui.splash.view.SplashMvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import javax.inject.Inject

class SplashPresenter<V: SplashMvpView, I: SplashMvpInteractor> @Inject constructor(interactor: I,
                                                                                    schedulerProvider: SchedulerProvider,
                                                                                    disposable: CompositeDisposable):
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    SplashMvpPresenter<V, I> {

    override fun checkToken(): Any? = getView()?.let { view ->

        interactor?.let {
            when (it.checkToken().isNullOrEmpty()) {
                true  -> view.openLoginScreen()
            }
        }

    }
}