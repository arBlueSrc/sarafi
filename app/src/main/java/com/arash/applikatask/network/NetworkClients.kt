package com.arash.applikatask.network

import com.arash.applikatask.utils.BASE_URL
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshiConverterFactory: MoshiConverterFactory
): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()
}

fun provideOkHttp(loggingInterceptor: LoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}

fun provideMoshiConverterFactory(moshi:Moshi):MoshiConverterFactory{
    return MoshiConverterFactory.create(moshi)
}

fun provideLoggingInterceptor(): LoggingInterceptor {
    return LoggingInterceptor.Builder()
        .setLevel(Level.BASIC)
        .build()
}

fun provideApiService(retrofit: Retrofit):ApiService{
    return retrofit.create(ApiService::class.java)
}

