package ru.rhdv.springhackapplication.util.errors_handler

interface ErrorsHandler {

    fun handleError(error: Int?, httpErrorCode: Int? = null)

}