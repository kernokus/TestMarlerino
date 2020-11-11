package com.example.testmarlerino.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.CookieManager
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class CookieModule {
    @Provides
    @Singleton
    fun provideCookieModule(@ApplicationContext context: Context): android.webkit.CookieManager {
        return android.webkit.CookieManager.getInstance()
    }
}