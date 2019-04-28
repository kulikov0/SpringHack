package ru.rhdv.springhackapplication.ui.login.interactor

import io.reactivex.Observable
import ru.rhdv.springhackapplication.data.network.response.LoginResponse
import ru.rhdv.springhackapplication.ui.base.interactor.MvpInteractor

interface LoginMvpInteractor: MvpInteractor {

    fun doServerLogin(login: String, password: String): Observable<LoginResponse>
    fun saveAccessToken(accessToken: String?)

}