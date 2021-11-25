package com.duongnh.beertestdemo.ui.beer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.duongnh.beertestdemo.models.BeerPresentation
import com.duongnh.domain.models.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.models.BeerRequest
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.GetBeersUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock


class BeersViewModelTest {
    private val getBeersRepository = mock(IGetBeersRepository::class.java)
    private lateinit var viewModel: BeersViewModel

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        viewModel = BeersViewModel(GetBeersUseCase(getBeersRepository))
    }

    @Test
    fun testInitialValue(){
        Assert.assertEquals(BeersViewState(isLoading = false, error = null, beers = null), viewModel.beersViewState.value)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetBeers(){
        val beers = mutableListOf<Beer>()
        beers.add(Beer(1, "Saigon", "Vip", "09/2007", "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.", "https://images.punkapi.com/v2/keg.png", 4.5f))

        runBlockingTest {
            getBeersRepository.getBeers(BeerRequest(1, 1)).collect {
                whenever(it).doReturn(beers)
                Assert.assertEquals(it, beers)
            }
        }
    }
}