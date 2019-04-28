package ru.rhdv.springhackapplication.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor
import ru.rhdv.springhackapplication.ui.base.view.MvpView
import ru.rhdv.springhackapplication.util.SchedulerProvider
import ru.rhdv.springhackapplication.util.errors_handler.ErrorsHandler

import javax.inject.Inject

abstract class BasePresenter<V: MvpView, I: MvpInteractor> internal constructor(protected var interactor: I?,
                                                                                protected var schedulerProvider: SchedulerProvider,
                                                                                protected val compositeDisposable: CompositeDisposable):
    MvpPresenter<V, I> {

    @Inject
    lateinit var errorsHandler: ErrorsHandler

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.clear()
        view?.hideProgress()
        view = null
    }

    override fun logout() = interactor?.clearPreferences().also { view?.logout() }

}