package ru.rhdv.springhackapplication.ui.developer_section.my_team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_team.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.DeveloperStatistic
import ru.rhdv.springhackapplication.util.extention.loadImage

class MyTeamFragment: Fragment() {

    companion object {
        const val TAG = "MyTeamFragment"
        fun newInstance(): MyTeamFragment = MyTeamFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_team_photo.loadImage("https://www.roundpegcomm.com/wp-content/uploads/2016/05/105-KJPP-Main-Image.jpg")
        rv_team_rating.layoutManager = LinearLayoutManager(requireContext())
        rv_team_rating.adapter = MyTeamAdapter( mutableListOf(DeveloperStatistic(
            developerName = "Александр Куликов",
            developerStatus = "Android Developer",
            developerPhotoLink = "https://images.unsplash.com/photo-1509070016581-915335454d19?ixlib=rb-1.2.1&w=1000&q=80",
            developerPoints = "200"),
            DeveloperStatistic(
                developerName = "Саша Серебренников",
                developerStatus = "Backend developer",
                developerPhotoLink = "https://cdn.serif.com/affinity/img/photo/home/0918/og-affinity-photo-120920181112.jpg",
                developerPoints = "190"),
            DeveloperStatistic(
                developerName = "Аркаша Дымков",
                developerStatus = "Team lead",
                developerPhotoLink = "https://envato-shoebox-0.imgix.net/4646/3935-85f4-41a0-b940-708875ee0a15/tajak+019.jpg?w=500&h=278&fit=crop&crop=edges&auto=compress%2Cformat&s=c45335aca948555287bc4229b1632950",
                developerPoints = "175"),
            DeveloperStatistic(
                developerName = "Коля Ксенофонтов",
                developerStatus = "Front",
                developerPhotoLink = "https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1000&q=80",
                developerPoints = "163"),
            DeveloperStatistic(
                developerName = "Иван Богомолов",
                developerStatus = "Developer",
                developerPhotoLink = "https://www.rencontres-arles.com/files/media_file_2106.jpg",
                developerPoints = "112")))
    }

}