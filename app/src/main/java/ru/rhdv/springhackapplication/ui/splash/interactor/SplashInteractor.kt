package ru.rhdv.springhackapplication.ui.splash.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class SplashInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), SplashMvpInteractor {

    override fun checkToken(): String? = preferencesHelper.getAccessToken()

}