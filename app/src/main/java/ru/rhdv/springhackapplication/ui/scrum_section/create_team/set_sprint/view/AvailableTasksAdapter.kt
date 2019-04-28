package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_task.view.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.AvailableTasksResponse
import ru.rhdv.springhackapplication.data.network.response.SelectedTasks

class AvailableTasksAdapter(private val tasksList: MutableList<AvailableTasksResponse>):
    RecyclerView.Adapter<AvailableTasksAdapter.SelectedTaskViewHolder>() {

    private lateinit var itemClickedCallback: OnItemClickListener

    interface OnItemClickListener {
        fun itemClicked(taskName: String, needRemove: Boolean)
    }

    fun setItemClickedListener(itemCategory: (position: String, needRemove: Boolean) -> Unit) {
        itemClickedCallback = object: OnItemClickListener {
            override fun itemClicked(taskName: String, needRemove: Boolean) {
                itemCategory(taskName,needRemove)
            }
        }
    }

    fun removeItems(selectedTasks: MutableList<SelectedTasks>) {
        selectedTasks.forEach { selectedTask ->
            tasksList.removeAll { it.taskName ==  selectedTask.taskName}
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedTaskViewHolder =
        SelectedTaskViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)))

    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: SelectedTaskViewHolder, position: Int) = holder.onBind(tasksList[position])

    inner class SelectedTaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var selected = false
        fun onBind(item: AvailableTasksResponse) {
            itemView.apply {
                tv_task_name.text = item.taskName
                setOnClickListener {
                    selected = if (!selected) {
                        itemClickedCallback.itemClicked(item.taskName!!, false)
                        setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.application_primary_light))
                        true
                    } else {
                        itemClickedCallback.itemClicked(item.taskName!!, true)
                        setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.bg_bottomsheet))
                        false
                    }
                }
            }
        }

    }

}