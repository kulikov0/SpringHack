package ru.mail.mailhackathonapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ru.rhdv.springhackapplication.data.network.ApiHeader
import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.network.AppApiHelper
import ru.rhdv.springhackapplication.data.preferences.AppPreferencesHelper
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.util.AppConstants
import ru.rhdv.springhackapplication.util.SchedulerProvider
import ru.rhdv.springhackapplication.util.errors_handler.ErrorsHandler
import ru.rhdv.springhackapplication.util.errors_handler.ErrorsHandlerImpl
import ru.rhdv.springhackapplication.util.navigator.Navigator
import ru.rhdv.springhackapplication.util.navigator.NavigatorImpl
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideNavigator(navigator: NavigatorImpl): Navigator = navigator

    @Provides
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper

    @Provides
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    internal fun provideErrorsHandler(errorsHandler: ErrorsHandlerImpl): ErrorsHandler = errorsHandler

    @Provides
    internal fun provideProtectedApiHelper(preferencesHelper: PreferencesHelper):
            ApiHeader.PublicApiHeader = ApiHeader.PublicApiHeader(apiKey = preferencesHelper.getAccessToken()!!)

}