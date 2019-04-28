package ru.rhdv.springhackapplication.ui.scrum_section.create_team.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_team_mate.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.AllDevelopersResponse
import ru.rhdv.springhackapplication.util.extention.loadImage

class ChooseDeveloperAdapter(private val developersList: MutableList<AllDevelopersResponse>):
    RecyclerView.Adapter<ChooseDeveloperAdapter.ChooseDeveloperViewHolder>() {

    private lateinit var itemClickedCallback: OnItemClickListener

    interface OnItemClickListener {
        fun itemClicked(developer: AllDevelopersResponse)
    }

    fun setItemClickedListener(itemCategory: (position: AllDevelopersResponse) -> Unit) {
        itemClickedCallback = object: OnItemClickListener {
            override fun itemClicked(developer: AllDevelopersResponse) {
                itemCategory(developer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseDeveloperViewHolder =
        ChooseDeveloperViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_team_mate, parent, false)))


    override fun getItemCount(): Int = developersList.size

    override fun onBindViewHolder(holder: ChooseDeveloperViewHolder, position: Int) = holder.onBind(position)


    inner class ChooseDeveloperViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            itemView.apply {
                tv_developer_name.text = developersList[position].developerName
                tv_developer_status.text = developersList[position].developerStatus
                developersList[position].developerPhotoLink?.let { developer_photo.loadImage(it) }
                setOnClickListener {
                    itemClickedCallback.itemClicked(developersList[position])
                    developersList.removeAt(position)
                    notifyDataSetChanged()
                }
            }
        }

    }

}