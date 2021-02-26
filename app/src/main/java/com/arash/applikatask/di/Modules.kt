package com.arash.applikatask.di

import com.arash.applikatask.ui.arz.ArzViewModel
import com.arash.applikatask.ui.car.CarViewModel
import com.arash.applikatask.ui.home.HomeViewModel
import com.arash.applikatask.ui.seke.SekeViewModel
import com.arash.applikatask.ui.splash.SplashViewModel
import com.arash.applikatask.network.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

}

val networkModules = module {
    single { provideLoggingInterceptor() }
    single { provideMoshi() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get(),get()) }
    single { provideApiService(get()) }
    single { provideMoshiConverterFactory(get()) }

    single<ApiRepository> { ApiRepositoryImp(get()) }
}

val viewModelModules = module {
    viewModel { ArzViewModel() }
    viewModel { CarViewModel() }
    viewModel { HomeViewModel(get(),get()) }
    viewModel { SekeViewModel() }
    viewModel { SplashViewModel() }
}