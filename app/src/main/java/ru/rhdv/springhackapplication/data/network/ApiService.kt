package ru.rhdv.springhackapplication.data.network

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import ru.rhdv.springhackapplication.data.network.request.LoginRequest
import ru.rhdv.springhackapplication.data.network.response.LoginResponse

interface ApiService {

    @POST("login")
    fun doUserLogin(@Body body: LoginRequest): Observable<Response<LoginResponse>>

}