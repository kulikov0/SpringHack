package ru.rhdv.springhackapplication.ui.base.view

interface MvpView {

    fun showProgress()

    fun hideProgress()

    fun logout(): Unit?

}