package com.example.mytime.di

import android.app.Application
import androidx.room.Room
import com.example.mytime.data.local.DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): DB {
        return Room.databaseBuilder(
            app,
            DB::class.java,
            "db"
        ).build()
    }
}