package ru.rhdv.springhackapplication.ui.splash.interactor

import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor

interface SplashMvpInteractor: MvpInteractor {

    fun checkToken(): String?

}