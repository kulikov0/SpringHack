package ru.rhdv.springhackapplication.ui.scrum_section.create_team.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_team.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.presenter.CreateTeamMvpPresenter
import javax.inject.Inject
import android.view.animation.TranslateAnimation
import android.view.View
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.interactor.CreateTeamMvpInteractor


class CreateTeamActivity: BaseActivity(R.layout.activity_create_team), CreateTeamMvpView {

    @Inject
    lateinit var presenter: CreateTeamMvpPresenter<CreateTeamMvpView, CreateTeamMvpInteractor>

    private lateinit var chooseDeveloperAdapter: ChooseDeveloperAdapter

    private lateinit var createTeamAdapter: CreateTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        setupAdapters()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        iv_add.setOnClickListener {
            ll_scale.visibility = View.VISIBLE
        }
    }

    private fun setupAdapters() {
        rv_team_mates_free.layoutManager = LinearLayoutManager(this)
        chooseDeveloperAdapter = ChooseDeveloperAdapter(presenter.getDevelpersList())
        rv_team_mates_free.adapter = chooseDeveloperAdapter
        chooseDeveloperAdapter.setItemClickedListener {
            iv_create.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    navigator.makeToast("Команда сформирована, и скоро появится в списке команд")
                    finish()
                }
            }
            createTeamAdapter.addTeamMate(it)
            ll_scale.visibility = View.GONE
        }
        rv_team_mates_added.layoutManager = LinearLayoutManager(this)
        createTeamAdapter = CreateTeamAdapter(mutableListOf())
        rv_team_mates_added.adapter = createTeamAdapter
    }

}