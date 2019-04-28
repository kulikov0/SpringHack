package ru.rhdv.springhackapplication.ui.developer_section.profile.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.UserBonusList
import ru.rhdv.springhackapplication.ui.base.view.BaseFragment
import ru.rhdv.springhackapplication.ui.developer_section.profile.interactor.ProfileFragmentMvpInteractor
import ru.rhdv.springhackapplication.ui.developer_section.profile.presenter.ProfileFragmentMvpPresenter
import ru.rhdv.springhackapplication.util.extention.loadImage
import javax.inject.Inject

class ProfileFragment: BaseFragment(R.layout.fragment_profile), ProfileFragmentMvpView {

    @Inject
    lateinit var presenter: ProfileFragmentMvpPresenter<ProfileFragmentMvpView, ProfileFragmentMvpInteractor>

    companion object {
        const val TAG = "ProfileFragment"
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        iv_user_photo.loadImage("https://images.unsplash.com/photo-1509070016581-915335454d19?ixlib=rb-1.2.1&w=1000&q=80")
        rv_bonus_history.layoutManager = LinearLayoutManager(requireContext())
        rv_bonus_history.adapter = ProfileAdapter(mutableListOf(
            UserBonusList(bonusDate = "12.04.2019", bonusName = "Закрытие спринта", bonusValue = "+40"),
            UserBonusList(bonusDate = "09.04.2019", bonusName = "Эффективная работа", bonusValue = "+25"),
            UserBonusList(bonusDate = "29.03.2019", bonusName = "Покрытие unit тестами", bonusValue = "+15"),
            UserBonusList(bonusDate = "25.03.2019", bonusName = "Закрытие спринта", bonusValue = "+40"),
            UserBonusList(bonusDate = "17.03.2019", bonusName = "Дисциплинарное взыскание", bonusValue = "-10"),
            UserBonusList(bonusDate = "04.03.2019", bonusName = "Закрытие спринта", bonusValue = "+40"),
            UserBonusList(bonusDate = "01.03.2019", bonusName = "Эффективная работа", bonusValue = "+25"),
            UserBonusList(bonusDate = "20.02.2019", bonusName = "Баги на проде", bonusValue = "-25"),
            UserBonusList(bonusDate = "15.02.2019", bonusName = "Закрытие спринта", bonusValue = "+40")
        ))
        iv_exit.setOnClickListener { presenter.logout() }
    }

}