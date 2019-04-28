package ru.rhdv.springhackapplication.ui.developer_section.teams_rating

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_teams_rating.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.TeamsRating
import ru.rhdv.springhackapplication.util.extention.loadImage

class TeamsRatingAdapter(val teamList: MutableList<TeamsRating>):
    RecyclerView.Adapter<TeamsRatingAdapter.TeamsRatingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsRatingViewHolder =
        TeamsRatingViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_teams_rating, parent, false)))

    override fun getItemCount(): Int = teamList.size


    override fun onBindViewHolder(holder: TeamsRatingViewHolder, position: Int) = holder.onBind(position)

    inner class TeamsRatingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            itemView.apply {
                if (position == 0 || position == 1 || position == 2) iv_star.visibility = View.VISIBLE
                tv_team_name.text = teamList[position].teamName
                teamList[position].teamPhoto.let { iv_team_photo.loadImage(it) }
                tv_team_rating.text = teamList[position].teamRating
                startAnimation(AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation_fall_down))

            }
        }

    }
}