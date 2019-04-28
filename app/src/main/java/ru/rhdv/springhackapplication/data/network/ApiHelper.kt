package ru.rhdv.springhackapplication.data.network

import io.reactivex.Observable
import ru.rhdv.springhackapplication.data.network.response.LoginResponse

interface ApiHelper {

    fun doUserLogin(login: String, password: String): Observable<LoginResponse>
}