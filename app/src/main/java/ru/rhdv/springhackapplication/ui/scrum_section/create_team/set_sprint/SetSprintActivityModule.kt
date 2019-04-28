package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor.SetSprintInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor.SetSprintMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.presenter.SetSprintMvpPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.presenter.SetSprintPresenter
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view.SetSprintMvpView

@Module
class SetSprintActivityModule {

    @Provides
    fun providesSetSprintInteractor(interactor: SetSprintInteractor): SetSprintMvpInteractor = interactor

    @Provides
    fun providesSetSprintPresenter(presenter: SetSprintPresenter<SetSprintMvpView, SetSprintMvpInteractor>):
            SetSprintMvpPresenter<SetSprintMvpView, SetSprintMvpInteractor> = presenter

}