package ru.rhdv.springhackapplication.ui.splash.presenter

import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.splash.interactor.SplashMvpInteractor
import ru.rhdv.springhackapplication.ui.splash.view.SplashMvpView

interface SplashMvpPresenter<V: SplashMvpView, I: SplashMvpInteractor>: MvpPresenter<V, I> {

    fun checkToken(): Any?

}