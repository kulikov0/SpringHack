package ru.rhdv.springhackapplication.ui.scrum_section.create_team

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.presenter.CreateTeamMvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.presenter.CreateTeamPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.view.CreateTeamMvpView

@Module
class CreateTeamActivityModule {

    @Provides
    fun providesCreateTeamInteractor(interactor: CreateTeamInteractor): CreateTeamMvpInteractor = interactor

    @Provides
    fun providesCreateTeamPresenter(presenter: CreateTeamPresenter<CreateTeamMvpView, CreateTeamMvpInteractor>):
            CreateTeamMvpPresenter<CreateTeamMvpView, CreateTeamMvpInteractor> = presenter

}