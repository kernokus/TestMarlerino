package com.example.testmarlerino.di
import com.example.testmarlerino.repo.NetworkRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetwRepoModule {
        @Provides
        @Singleton
        fun provideNetworkModule(): NetworkRepo {
            return NetworkRepo()
        }
    }
