package ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_set_sprint.*
import ru.mail.mailhackathonapplication.R
import ru.rhdv.springhackapplication.data.network.response.SelectedTasks
import ru.rhdv.springhackapplication.ui.base.view.BaseActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.interactor.SetSprintMvpInteractor
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.presenter.SetSprintMvpPresenter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class SetSprintActivity: BaseActivity(R.layout.activity_set_sprint), SetSprintMvpView {

    @Inject
    lateinit var presenter: SetSprintMvpPresenter<SetSprintMvpView, SetSprintMvpInteractor>

    private lateinit var availableTasksAdapter: AvailableTasksAdapter

    private lateinit var addTaskAdapter: AddTaskAdapter

    private val selectedTasks = mutableListOf<SelectedTasks>()

    private var taskStoryPoints = "1"

    private var taskTime = "1"

    private val tasksAvailableStoryPoint = listOf("1", "2", "3", "5", "8", "13", "21", "34", "55", "89")

    private val tasksAvailableTime = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        setOnClickListeners()
        setupSpinner()
        setupSpinnerHours()
        setupAdapters()
    }

    private fun setupAdapters() {
        rv_tasks_available.layoutManager = LinearLayoutManager(this)
        availableTasksAdapter = AvailableTasksAdapter(presenter.getAvailableTasks())
        rv_tasks_available.adapter = availableTasksAdapter
        availableTasksAdapter.setItemClickedListener { name, needRemove ->
            if (!needRemove) selectedTasks.add(SelectedTasks(taskName = name, taskStoryPoints = taskStoryPoints, taskHours = taskTime ))
            else selectedTasks.removeAll { it.taskName == name }
        }
        rv_tasks_added.layoutManager = LinearLayoutManager(this)
        addTaskAdapter = AddTaskAdapter(mutableListOf())
        rv_tasks_added.adapter = addTaskAdapter

    }

    @SuppressLint("SimpleDateFormat")
    private fun setOnClickListeners() {
        sprint_start_picker.setOnClickListener {
            Calendar.getInstance().let { calendar ->
                val picker = DatePickerDialog(this, R.style.CustomDatePickerDialog, DatePickerDialog.OnDateSetListener{
                        _, year, month, day ->
                    calendar.set(year, month, day)
                    sprint_start_text.text = SimpleDateFormat("dd/MM/yyyy")
                        .format(calendar.time)
                        .toString()
                        .replace("/",".")
                    //birthday = (calendar.timeInMillis / 1000L).toInt()

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

                picker.datePicker.maxDate = calendar.timeInMillis
                picker.show()
            }

        }
        sprint_end_picker.setOnClickListener {
            Calendar.getInstance().let { calendar ->
                val picker = DatePickerDialog(this, R.style.CustomDatePickerDialog, DatePickerDialog.OnDateSetListener{
                        _, year, month, day ->
                    calendar.set(year, month, day)
                    sprint_end_text.text = SimpleDateFormat("dd/MM/yyyy")
                        .format(calendar.time)
                        .toString()
                        .replace("/",".")
                    //birthday = (calendar.timeInMillis / 1000L).toInt()

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

                picker.datePicker.minDate = calendar.timeInMillis + 604800000
                picker.show()
            }

        }

        btn_add_task.setOnClickListener {
            ll_scale.visibility = View.GONE
            availableTasksAdapter.removeItems(selectedTasks)
            addTaskAdapter.addTasks(selectedTasks)
            selectedTasks.clear()
            }
        iv_add_task.setOnClickListener { ll_scale.visibility = View.VISIBLE }
        btn_create.setOnClickListener {
            navigator.makeToast("Спринт успешно создан и скоро появится")
            finish()
        }

    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tasksAvailableStoryPoint)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_time.adapter = adapter
        spinner_time.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                taskStoryPoints = tasksAvailableStoryPoint[position]
            }

        }
    }

    private fun setupSpinnerHours() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tasksAvailableTime)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_hours.adapter = adapter
        spinner_hours.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                taskTime = tasksAvailableTime[position]
            }

        }
    }

}