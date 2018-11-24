package com.brotherhood.gramatyka.di.modules

import dagger.Module
import dagger.Provides
import hackyeah.com.hackyeah.BuildConfig
import hackyeah.com.hackyeah.data.ApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideApi(): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(OkHttpClient())
                .build()
        return retrofit.create(ApiService::class.java)
    }
}