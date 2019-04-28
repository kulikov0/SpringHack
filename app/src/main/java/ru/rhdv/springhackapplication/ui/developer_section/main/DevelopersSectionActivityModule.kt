package ru.rhdv.springhackapplication.ui.developer_section.main

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.developer_section.main.interactor.DevelopersSectionInteractor
import ru.rhdv.springhackapplication.ui.developer_section.main.interactor.DevelopersSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.main.presenter.DevelopersSectionMvpPresenter
import ru.rhdv.springhackapplication.ui.developer_section.main.presenter.DevelopersSectionPresenter
import ru.rhdv.springhackapplication.ui.developer_section.main.view.DevelopersSectionMvpView

@Module
class DevelopersSectionActivityModule {

    @Provides
    fun providesDevelopersSectionInteractor(interactor: DevelopersSectionInteractor): DevelopersSectionMvpInteractor = interactor

    @Provides
    fun providesDevelopersSectionPresenter(presenter: DevelopersSectionPresenter<DevelopersSectionMvpView, DevelopersSectionMvpInteractor>):
            DevelopersSectionMvpPresenter<DevelopersSectionMvpView, DevelopersSectionMvpInteractor> = presenter

}