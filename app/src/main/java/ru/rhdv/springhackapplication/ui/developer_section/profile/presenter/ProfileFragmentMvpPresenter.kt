package ru.rhdv.springhackapplication.ui.developer_section.profile.presenter

import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.developer_section.profile.interactor.ProfileFragmentMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.profile.view.ProfileFragmentMvpView

interface ProfileFragmentMvpPresenter<V: ProfileFragmentMvpView, I: ProfileFragmentMvpInteractor>: MvpPresenter<V, I>