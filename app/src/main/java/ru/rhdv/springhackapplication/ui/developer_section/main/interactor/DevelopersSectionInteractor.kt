package ru.rhdv.springhackapplication.ui.developer_section.main.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class DevelopersSectionInteractor @Inject constructor(apiHelper: ApiHelper, preferesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferesHelper), DevelopersSectionMvpInteractor