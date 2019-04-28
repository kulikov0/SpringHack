package ru.rhdv.springhackapplication.ui.developer_section.profile.view

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_bonus_history.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.data.network.response.SelectedTasks
import ru.rhdv.springhackapplication.data.network.response.UserBonusList

class ProfileAdapter(private val tasksList: MutableList<UserBonusList>):
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder =
        ProfileViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_bonus_history, parent, false)))

    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) = holder.onBind(position)

    inner class ProfileViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {
            itemView.apply {
                tv_task_name.text = tasksList[position].bonusName
                tv_reach_time.text = tasksList[position].bonusDate
                tv_bonus_size.text = tasksList[position].bonusValue
            }
        }

    }

}