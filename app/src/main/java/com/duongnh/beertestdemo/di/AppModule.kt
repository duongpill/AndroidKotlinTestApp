package com.duongnh.beertestdemo.di

import com.duongnh.beertestdemo.network.RetrofitModule
import com.duongnh.data.IRetrofitModule
import com.duongnh.data.repository.GetBeersRepository
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun bindRetrofitModule(): IRetrofitModule = RetrofitModule()

    @Provides
    @Singleton
    fun bindGetBeersRepository(retrofitModule: IRetrofitModule): IGetBeersRepository = GetBeersRepository(retrofitModule)

    @Provides
    @Singleton
    fun bindGetBeersUseCase(getBeersRepository: IGetBeersRepository) = GetBeersUseCase(getBeersRepository)

}