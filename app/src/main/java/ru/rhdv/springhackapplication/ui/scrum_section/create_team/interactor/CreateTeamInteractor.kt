package ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor

import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class CreateTeamInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), CreateTeamMvpInteractor {


    override fun getAvailableDevelopersList(): MutableList<AllDevelopersResponse> = mutableListOf(
        AllDevelopersResponse(developerId = 1,
            developerName = "Александр Куликов",
            developerStatus = "Android Developer",
            developerPhotoLink = "https://images.unsplash.com/photo-1509070016581-915335454d19?ixlib=rb-1.2.1&w=1000&q=80"),
        AllDevelopersResponse(developerId = 2,
            developerName = "Александр Серебренников",
            developerStatus = "Backend developer",
            developerPhotoLink = "https://cdn.serif.com/affinity/img/photo/home/0918/og-affinity-photo-120920181112.jpg"),
        AllDevelopersResponse(developerId = 3,
            developerName = "Аркаша",
            developerStatus = "Team lead",
            developerPhotoLink = "https://envato-shoebox-0.imgix.net/4646/3935-85f4-41a0-b940-708875ee0a15/tajak+019.jpg?w=500&h=278&fit=crop&crop=edges&auto=compress%2Cformat&s=c45335aca948555287bc4229b1632950"),
        AllDevelopersResponse(developerId = 4,
            developerName = "Коля",
            developerStatus = "Front",
            developerPhotoLink = "https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1000&q=80"),
        AllDevelopersResponse(developerId = 5,
            developerName = "Иван Богомолов",
            developerStatus = "Developer",
            developerPhotoLink = "https://www.rencontres-arles.com/files/media_file_2106.jpg"))

}