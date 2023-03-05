package com.zlsp.calcxe.di

import android.content.Context
import android.content.SharedPreferences
import com.zlsp.calcxe.data.UserStorage
import com.zlsp.calcxe.data.repositories.settings.SettingsRepository
import com.zlsp.calcxe.data.repositories.settings.SettingsRepositoryImpl
import com.zlsp.calcxe.data.repositories.theme.ThemeRepository
import com.zlsp.calcxe.data.repositories.theme.ThemeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideUserStorage(pref: SharedPreferences): UserStorage =
        UserStorage(pref)

    @Provides
    @Singleton
    fun provideSettingsRepository(userStorage: UserStorage): SettingsRepository =
        SettingsRepositoryImpl(userStorage)

    @Provides
    @Singleton
    fun provideThemeRepository(userStorage: UserStorage): ThemeRepository =
        ThemeRepositoryImpl(userStorage)
}