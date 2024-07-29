package com.main.presentation.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.RemoteMediator
import androidx.room.Room
import com.main.data.local.RecipeApiDB.RecipeApiDB
import com.main.data.local.RecipeApiDB.RecipeApiEntity
import com.main.data.remote.RecipeApi
import com.main.data.remote.RecipeRemoteMediator
import com.main.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RecipeApiDB {
        return Room.databaseBuilder(
            context,
            RecipeApiDB::class.java,
            "recipeApi.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
