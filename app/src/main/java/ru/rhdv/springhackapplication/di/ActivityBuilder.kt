package ru.rhdv.springhackapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rhdv.springhackapplication.ui.developer_section.main.DevelopersSectionActivityModule
import ru.rhdv.springhackapplication.ui.developer_section.main.view.DeveloperSectionActivity
import ru.rhdv.springhackapplication.ui.developer_section.profile.ProfileFragmentProvider
import ru.rhdv.springhackapplication.ui.login.LoginActivityModule
import ru.rhdv.springhackapplication.ui.login.view.LoginActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.CreateTeamActivityModule
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.SetSprintActivityModule
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.set_sprint.view.SetSprintActivity
import ru.rhdv.springhackapplication.ui.scrum_section.create_team.view.CreateTeamActivity
import ru.rhdv.springhackapplication.ui.scrum_section.main.ScrumSectionActivityModule
import ru.rhdv.springhackapplication.ui.scrum_section.main.view.ScrumSectionActivity
import ru.rhdv.springhackapplication.ui.splash.SplashActivityModule
import ru.rhdv.springhackapplication.ui.splash.view.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [DevelopersSectionActivityModule::class, ProfileFragmentProvider::class])
    abstract fun bindDevelopersSection(): DeveloperSectionActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [ScrumSectionActivityModule::class])
    abstract fun bindScrumSectionActivity(): ScrumSectionActivity

    @ContributesAndroidInjector(modules = [CreateTeamActivityModule::class])
    abstract fun bindCreateTeamActivity(): CreateTeamActivity

    @ContributesAndroidInjector(modules = [SetSprintActivityModule::class])
    abstract fun bindSetSprintActivity(): SetSprintActivity

}