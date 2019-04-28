package ru.rhdv.springhackapplication.ui.developer_section.main.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_developer_section.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import ru.rhdv.springhackapplication.ui.custom.bottomnavigation.CustomBottomNavigationView
import ru.rhdv.springhackapplication.ui.developer_section.main.interactor.DevelopersSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.main.presenter.DevelopersSectionMvpPresenter
import ru.rhdv.springhackapplication.util.extention.*
import javax.inject.Inject

class DeveloperSectionActivity: BaseActivity(R.layout.activity_developer_section), DevelopersSectionMvpView, BottomNavigationView.OnNavigationItemSelectedListener,
    HasSupportFragmentInjector {

    @Inject
    lateinit var presenter: DevelopersSectionMvpPresenter<DevelopersSectionMvpView, DevelopersSectionMvpInteractor>

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    private lateinit var bottomNavigation: CustomBottomNavigationView

    private var navPosition: BottomNavigationPosition =
        BottomNavigationPosition.BOSS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        bottomNavigation = bottom_navigation_bar
        initBottomNavigation()
        initFragment(savedInstanceState)
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: switchFragment(BottomNavigationPosition.BOSS)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navPosition = findNavigationPositionById(item.itemId)
        return switchFragment(navPosition)
    }

    private fun initBottomNavigation() {
        bottomNavigation.active(navPosition.position)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }


    fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
        BottomNavigationPosition.BOSS.id         -> BottomNavigationPosition.BOSS
        BottomNavigationPosition.MY_TEAM.id      -> BottomNavigationPosition.MY_TEAM
        BottomNavigationPosition.PROFILE.id      -> BottomNavigationPosition.PROFILE
        BottomNavigationPosition.TEAMS_RATING.id -> BottomNavigationPosition.TEAMS_RATING
        else                                     -> BottomNavigationPosition.BOSS
    }

    private fun switchFragment(navPosition: BottomNavigationPosition): Boolean {
        return supportFragmentManager.findFragment(navPosition).let {
            if (it.isAdded) return false
            supportFragmentManager.detach()
            supportFragmentManager.attach(it, navPosition.getTag())
            supportFragmentManager.executePendingTransactions()
        }
    }

}