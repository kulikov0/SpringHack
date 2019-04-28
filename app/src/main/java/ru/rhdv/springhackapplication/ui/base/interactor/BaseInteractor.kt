package ru.rhdv.springhackapplication.ui.base.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper

open class BaseInteractor(): MvpInteractor {

    lateinit var preferencesHelper: PreferencesHelper
    lateinit var apiHelper: ApiHelper

    constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper): this() {
        this.preferencesHelper = preferencesHelper
        this.apiHelper = apiHelper
    }

    override fun clearPreferences() = preferencesHelper.clearAll()

}