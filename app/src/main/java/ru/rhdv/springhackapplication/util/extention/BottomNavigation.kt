package ru.rhdv.springhackapplication.util.extention

import android.support.v4.app.Fragment
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.custom.bottomnavigation.CustomBottomNavigationView
import ru.rhdv.springhackapplication.ui.developer_section.boss.BossFragment
import ru.rhdv.springhackapplication.ui.developer_section.my_team.MyTeamFragment
import ru.rhdv.springhackapplication.ui.developer_section.profile.view.ProfileFragment
import ru.rhdv.springhackapplication.ui.developer_section.teams_rating.TeamsRatingFragment

fun CustomBottomNavigationView.active(position: Int) {
    menu.getItem(position).isChecked = true
}

enum class  BottomNavigationPosition(val position: Int, val id: Int) {
    BOSS(0, R.id.navigation_boss),
    MY_TEAM(1, R.id.navigation_my_team),
    PROFILE(2, R.id.navigation_profile),
    TEAMS_RATING(3, R.id.navigation_teams_rating);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.BOSS.id              -> BottomNavigationPosition.BOSS
    BottomNavigationPosition.MY_TEAM.id           -> BottomNavigationPosition.MY_TEAM
    BottomNavigationPosition.PROFILE.id           -> BottomNavigationPosition.PROFILE
    BottomNavigationPosition.TEAMS_RATING.id      -> BottomNavigationPosition.TEAMS_RATING
    else                                          -> BottomNavigationPosition.BOSS
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.BOSS         -> BossFragment.newInstance()
    BottomNavigationPosition.MY_TEAM      -> MyTeamFragment.newInstance()
    BottomNavigationPosition.PROFILE      -> ProfileFragment.newInstance()
    BottomNavigationPosition.TEAMS_RATING -> TeamsRatingFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.BOSS         -> BossFragment.TAG
    BottomNavigationPosition.MY_TEAM      -> MyTeamFragment.TAG
    BottomNavigationPosition.PROFILE      -> ProfileFragment.TAG
    BottomNavigationPosition.TEAMS_RATING -> TeamsRatingFragment.TAG
}