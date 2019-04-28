package ru.rhdv.springhackapplication.ui.scrum_section.create_team.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_team_mate.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.util.extention.loadImage

class CreateTeamAdapter(val developersList: MutableList<AllDevelopersResponse>):
    RecyclerView.Adapter<CreateTeamAdapter.CreateTeamViewHolder>() {

    fun addTeamMate(developer: AllDevelopersResponse) {
        developersList.add(developer)
        notifyItemInserted(developersList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateTeamViewHolder =
        CreateTeamViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_team_mate, parent, false)))

    override fun getItemCount(): Int = developersList.size

    override fun onBindViewHolder(holder: CreateTeamViewHolder, position: Int) = holder.onBind(position)

    inner class CreateTeamViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            itemView.apply {
                tv_developer_name.text = developersList[position].developerName
                tv_developer_status.text = developersList[position].developerStatus
                developersList[position].developerPhotoLink?.let { developer_photo.loadImage(it) }
                startAnimation(AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation_fall_down))

            }
        }

    }

}