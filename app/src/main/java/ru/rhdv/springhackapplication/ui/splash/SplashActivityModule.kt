package ru.rhdv.springhackapplication.ui.splash

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.splash.interactor.SplashInteractor
import ru.rhdv.springhackapplication.ui.splash.interactor.SplashMvpInteractor
import ru.rhdv.springhackapplication.ui.splash.presenter.SplashMvpPresenter
import ru.rhdv.springhackapplication.ui.splash.presenter.SplashPresenter
import ru.rhdv.springhackapplication.ui.splash.view.SplashMvpView

@Module
class SplashActivityModule {

    @Provides
    fun providesSplashInteractor(interactor: SplashInteractor): SplashMvpInteractor = interactor

    @Provides
    fun providesSplashPresenter(presenter: SplashPresenter<SplashMvpView, SplashMvpInteractor>):
            SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> = presenter

}