package ru.rhdv.springhackapplication.ui.base.presenter

import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor
import ru.rhdv.springhackapplication.ui.base.view.MvpView

interface MvpPresenter<V: MvpView, I: MvpInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

    fun logout(): Unit?

}