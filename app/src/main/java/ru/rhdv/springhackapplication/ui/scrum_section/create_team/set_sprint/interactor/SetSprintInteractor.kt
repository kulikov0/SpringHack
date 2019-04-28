package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class SetSprintInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper),
        SetSprintMvpInteractor {


    override fun getAvailableTasks(): MutableList<AvailableTasksResponse> = mutableListOf(
        AvailableTasksResponse(id = 1, taskName = "Базовая архитектура"),
        AvailableTasksResponse(id = 2, taskName = "Реализация mvp"),
        AvailableTasksResponse(id = 3, taskName = "Экран логина"),
        AvailableTasksResponse(id = 4, taskName = "Экран дашборда"),
        AvailableTasksResponse(id = 5, taskName = "Экраны регистрации"),
        AvailableTasksResponse(id = 6, taskName = "БД"),
        AvailableTasksResponse(id = 7, taskName = "Изучение конкурентов"),
        AvailableTasksResponse(id = 8, taskName = "Добавление карт"),
        AvailableTasksResponse(id = 9, taskName = "Авторизация через ВК")
    )

}