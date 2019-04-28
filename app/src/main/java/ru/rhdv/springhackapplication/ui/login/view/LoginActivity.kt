package ru.rhdv.springhackapplication.ui.login.view

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import ru.rhdv.springhackapplication.ui.login.interactor.LoginMvpInteractor
import ru.rhdv.springhackapplication.ui.login.presenter.LoginMvpPresenter
import javax.inject.Inject

class LoginActivity: BaseActivity(R.layout.activity_login), LoginMvpView {

    @Inject
    lateinit var presenter: LoginMvpPresenter<LoginMvpView, LoginMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        btn_login.setOnClickListener {
            when {
                input_email.text.toString() == "developer" -> navigator.openDeveloperSection()
                input_email.text.toString() == "scrum" -> navigator.openScrumSectionScreen()
                else -> navigator.makeToast("Пользователь не найлен")
            }
        }
    }


}