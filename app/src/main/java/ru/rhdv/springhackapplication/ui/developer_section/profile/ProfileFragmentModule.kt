package ru.rhdv.springhackapplication.ui.developer_section.profile

import dagger.Module
import dagger.Provides
import ru.rhdv.springhackapplication.ui.developer_section.profile.interactor.ProfileFragmentInteractor
import ru.rhdv.springhackapplication.ui.developer_section.profile.interactor.ProfileFragmentMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.profile.presenter.ProfileFragmentMvpPresenter
import ru.rhdv.springhackapplication.ui.developer_section.profile.presenter.ProfileFragmentPresenter
import ru.rhdv.springhackapplication.ui.developer_section.profile.view.ProfileFragmentMvpView

@Module
class ProfileFragmentModule {

    @Provides
    fun providesProfileFragmentInteractor(interactor: ProfileFragmentInteractor): ProfileFragmentMvpInteractor = interactor

    @Provides
    fun providesProfileFragmentPresenter(presenter: ProfileFragmentPresenter<ProfileFragmentMvpView, ProfileFragmentMvpInteractor>):
            ProfileFragmentMvpPresenter<ProfileFragmentMvpView, ProfileFragmentMvpInteractor> = presenter

}