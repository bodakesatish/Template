package com.bodakesatish.data.di

import android.content.Context
import androidx.room.Room
import com.bodakesatish.data.source.local.database.MemberDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val  DATABASE_NAME = "member.db"

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext appContext: Context): MemberDatabase {
        return Room.databaseBuilder(
            appContext,
            MemberDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun providesMemberDao(database: MemberDatabase) = database.memberDao()

}