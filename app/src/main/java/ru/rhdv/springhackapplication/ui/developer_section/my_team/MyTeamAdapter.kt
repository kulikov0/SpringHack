package ru.rhdv.springhackapplication.ui.developer_section.my_team

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_developer.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.DeveloperStatistic
import ru.rhdv.springhackapplication.util.extention.loadImage

class MyTeamAdapter(val teamList: MutableList<DeveloperStatistic>):
    RecyclerView.Adapter<MyTeamAdapter.MyTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTeamViewHolder =
        MyTeamViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_developer, parent, false)))

    override fun getItemCount(): Int = teamList.size


    override fun onBindViewHolder(holder: MyTeamViewHolder, position: Int) = holder.onBind(position)

    inner class MyTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            itemView.apply {
                tv_developer_name.text = teamList[position].developerName
                teamList[position].developerPhotoLink.let { developer_photo.loadImage(it) }
                tv_developer_status.text = teamList[position].developerStatus
                tv_developer_rating.text = teamList[position].developerPoints
                startAnimation(AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation_fall_down))

            }
        }

    }
}