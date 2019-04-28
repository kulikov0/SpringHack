package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_task_selected.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.SelectedTasks

class AddTaskAdapter(val tasksList: MutableList<SelectedTasks>):
    RecyclerView.Adapter<AddTaskAdapter.AddTaskViewHolder>() {

    fun addTasks(tasks: MutableList<SelectedTasks>) {
        tasks.forEach {
            tasksList.add(it)
            notifyItemInserted(tasksList.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddTaskViewHolder =
        AddTaskViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_task_selected, parent, false)))

    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: AddTaskViewHolder, position: Int) = holder.onBind(position)

    inner class AddTaskViewHolder(view: View): RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun onBind(position: Int) {
            itemView.apply {
                tv_task_name.text = tasksList[position].taskName
                tv_task_storypoints.text = "${tasksList[position].taskStoryPoints}sp"
                tv_task_time.text = "${tasksList[position].taskHours}ч"
                startAnimation(AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation_fall_down))

            }
        }

    }

}