package ru.rhdv.springhackapplication.ui.scrum_section.main

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.scrum_section.main.interactor.ScrumSectionInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.main.interactor.ScrumSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.main.presenter.ScrumSectionMvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.main.presenter.ScrumSectionPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.main.view.ScrumSectionMvpView

@Module
class ScrumSectionActivityModule {

    @Provides
    fun providesScrumSectionInteractor(interactor: ScrumSectionInteractor): ScrumSectionMvpInteractor = interactor

    @Provides
    fun providesScrumSectionPresenter(presenter: ScrumSectionPresenter<ScrumSectionMvpView, ScrumSectionMvpInteractor>):
            ScrumSectionMvpPresenter<ScrumSectionMvpView, ScrumSectionMvpInteractor> = presenter

}