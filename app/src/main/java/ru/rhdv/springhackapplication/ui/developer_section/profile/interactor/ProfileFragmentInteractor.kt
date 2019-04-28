package ru.rhdv.springhackapplication.ui.developer_section.profile.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ProfileFragmentInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), ProfileFragmentMvpInteractor