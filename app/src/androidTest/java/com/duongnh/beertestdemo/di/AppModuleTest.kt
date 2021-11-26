package com.duongnh.beertestdemo.di

import com.duongnh.beertestdemo.data.FakeGetBeersRepository
import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.base.BaseUseCase
import com.duongnh.domain.usecases.GetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTest{

    @Provides
    fun provideGetBeersRepository(): IGetBeersRepository = FakeGetBeersRepository()

    @Provides
    @Singleton
    fun provideGetBeersUseCase(getBeersRepository: IGetBeersRepository): BaseUseCase<BaseRequest, Flow<List<Beer>>> = GetBeersUseCase(getBeersRepository)

}