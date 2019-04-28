package ru.rhdv.springhackapplication.ui.scrum_section.main.view

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scrum_section.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import ru.rhdv.springhackapplication.ui.scrum_section.main.interactor.ScrumSectionMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.main.presenter.ScrumSectionMvpPresenter
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager



class ScrumSectionActivity: BaseActivity(R.layout.activity_scrum_section), ScrumSectionMvpView {

    @Inject
    lateinit var presenter: ScrumSectionMvpPresenter<ScrumSectionMvpView, ScrumSectionMvpInteractor>

    lateinit var scrumSectionAdapter: ScrumSectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        setOnClickListeners()
        setupAdapters()
    }

    private fun setupAdapters() {
        rv_teams.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        scrumSectionAdapter = ScrumSectionAdapter(presenter.getAllTeans())
        rv_teams.adapter = scrumSectionAdapter
        scrumSectionAdapter.setItemClickedListener { position, available ->
            if (available) navigator.openSetSprintScreen()
        }
    }

    private fun setOnClickListeners() {
        iv_create_team.setOnClickListener { navigator.openCreateTeamScreen() }
        tv_exit.setOnClickListener { presenter.logout() }
    }

}