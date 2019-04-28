package ru.rhdv.springhackapplication.util.navigator

import android.content.Context
import android.content.Intent
import android.widget.Toast
import ru.rhdv.springhackapplication.ui.developer_section.main.view.DeveloperSectionActivity
import ru.rhdv.springhackapplication.ui.login.view.LoginActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view.SetSprintActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.view.CreateTeamActivity
import ru.rhdv.springhackapplication.ui.scrum_section.main.view.ScrumSectionActivity
import javax.inject.Inject


class NavigatorImpl @Inject constructor(val context: Context): Navigator {

    private val defaultFlag = Intent.FLAG_ACTIVITY_NEW_TASK

    override fun makeToast(toast: String) = Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()

    override fun openLoginScreen() = context.startActivity(Intent(context, LoginActivity::class.java)
        .addFlags(defaultFlag)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))

    override fun openDeveloperSection() = context.startActivity(Intent(context, DeveloperSectionActivity::class.java)
        .addFlags(defaultFlag)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))

    override fun openCreateTeamScreen() = context.startActivity(Intent(context, CreateTeamActivity::class.java)
        .addFlags(defaultFlag))

    override fun openScrumSectionScreen() = context.startActivity(Intent(context, ScrumSectionActivity::class.java)
        .addFlags(defaultFlag))

    override fun openSetSprintScreen() = context.startActivity(Intent(context, SetSprintActivity::class.java)
        .addFlags(defaultFlag))
}