package ru.rhdv.springhackapplication.ui.developer_section.profile

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rhdv.springhackapplication.ui.developer_section.profile.view.ProfileFragment

@Module
abstract class ProfileFragmentProvider {

    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

}