package com.duongnh.beertestdemo.di

import com.duongnh.beertestdemo.data.TestGetBeerRepository
import com.duongnh.beertestdemo.domain.TestGetBeerUseCase
import com.duongnh.beertestdemo.network.RetrofitClient
import com.duongnh.data.IRetrofitClient
import com.duongnh.data.repository.GetBeersRepository
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {
    @Provides
    @Singleton
    fun bindGetBeersRepository(): IGetBeersRepository = TestGetBeerRepository()

    @Provides
    @Singleton
    fun bindGetBeersUseCase(testGetBeerRepository: IGetBeersRepository) = TestGetBeerUseCase(testGetBeerRepository)
}