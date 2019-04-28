package ru.rhdv.springhackapplication.ui.developer_section.main.presenter

import ru.rhdv.springhackapplication.ui.base.presenter.MvpPresenter
import ru.rhdv.springhackapplication.ui.developer_section.main.interactor.DevelopersSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.main.view.DevelopersSectionMvpView

interface DevelopersSectionMvpPresenter<V: DevelopersSectionMvpView, I: DevelopersSectionMvpInteractor>: MvpPresenter<V, I>