package com.duongnh.newtechnology2021demo.ui.beer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.duongnh.newtechnology2021demo.data.FakeTestGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BeersViewModelTest {

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    lateinit var beersViewModel: BeersViewModel

    @Before
    fun setup(){
        beersViewModel = BeersViewModel(GetBeersUseCase(FakeTestGetBeersRepository()))
    }

    @Test
    fun `get beers list with the invalid size`(){
        beersViewModel.getBeers(1, 2)
        Assert.assertEquals(3, beersViewModel.beersViewState.value?.beers?.size)
    }

    @Test
    fun `get beers list with the valid size`(){
        beersViewModel.getBeers(1, 2)
        Assert.assertEquals(2, beersViewModel.beersViewState.value?.beers?.size)
    }

}