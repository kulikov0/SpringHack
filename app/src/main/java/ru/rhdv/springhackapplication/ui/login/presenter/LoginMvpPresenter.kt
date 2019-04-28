package ru.rhdv.springhackapplication.ui.login.presenter

import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.login.interactor.LoginMvpInteractor
import ru.rhdv.springhackapplication.ui.login.view.LoginMvpView

interface LoginMvpPresenter<V: LoginMvpView, I: LoginMvpInteractor>: MvpPresenter<V, I> {

    fun doServerLogin(login: String, password: String): Any?

}