package ru.rhdv.springhackapplication.ui.scrum_section.main.view

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_teams.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.AllTeamsResponse
import ru.rhdv.springhackapplication.util.extention.loadImage

class ScrumSectionAdapter(val teamList: MutableList<AllTeamsResponse>):
    RecyclerView.Adapter<ScrumSectionAdapter.ScrumSectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrumSectionViewHolder =
        ScrumSectionViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false)))

    override fun getItemCount(): Int = teamList.size

    private lateinit var itemClickedCallback: OnItemClickListener

    interface OnItemClickListener {
        fun itemClicked(teamId: Int, available: Boolean)
    }

    fun setItemClickedListener(itemCategory: (position: Int, available: Boolean) -> Unit) {
        itemClickedCallback = object: OnItemClickListener {
            override fun itemClicked(teamId: Int, available: Boolean) {
                itemCategory(teamId, available)
            }
        }
    }

    override fun onBindViewHolder(holder: ScrumSectionViewHolder, position: Int) = holder.onBind(position)

    inner class ScrumSectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            itemView.apply {
                tv_team_name.text = teamList[position].teamName
                when(teamList[position].teamAvailable!!) {
                    false -> {
                        tv_team_available.text = "Заняты"
                        tv_team_available.setTextColor(ContextCompat.getColor(context, R.color.red))
                        setOnClickListener { itemClickedCallback.itemClicked(teamList[position].id!!, false) }
                    }
                    true -> {
                        tv_team_available.text = "Свободны"
                        tv_team_available.setTextColor(ContextCompat.getColor(context, R.color.green))
                        setOnClickListener { itemClickedCallback.itemClicked(teamList[position].id!!, true) }
                    }
                }
                teamList[position].teamPhoto?.let { iv_team_photo.loadImage(it) }
                startAnimation(AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation_fall_down))

            }
        }

    }
}
