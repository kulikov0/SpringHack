package ru.rhdv.springhackapplication.ui.login

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.login.interactor.LoginInteractor
import ru.rhdv.springhackapplication.ui.login.interactor.LoginMvpInteractor
import ru.rhdv.springhackapplication.ui.login.presenter.LoginMvpPresenter
import ru.rhdv.springhackapplication.ui.login.presenter.LoginPresenter
import ru.rhdv.springhackapplication.ui.login.view.LoginMvpView

@Module
class LoginActivityModule {

    @Provides
    fun provideLoginInteractor(interactor: LoginInteractor): LoginMvpInteractor = interactor

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter<LoginMvpView, LoginMvpInteractor>):
            LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> = presenter

}