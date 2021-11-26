package com.duongnh.beertestdemo.data

import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.repository.IGetBeersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetBeersRepository: IGetBeersRepository {
    override suspend fun getBeers(params: BaseRequest): Flow<List<Beer>> = flow {
        val beers = mutableListOf<Beer>()
        beers.add(Beer(1, "Buzz", "A Real Bitter Experience.", "09/2007", "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.", "https://images.punkapi.com/v2/keg.png", 4.5f))
        beers.add(Beer(2, "Trashy Blonde", "You Know You Shouldn't", "04/2008", "A titillating, neurotic, peroxide punk of a Pale Ale. Combining attitude, style, substance, and a little bit of low self esteem for good measure; what would your mother say? The seductive lure of the sassy passion fruit hop proves too much to resist. All that is even before we get onto the fact that there are no additives, preservatives, pasteurization or strings attached. All wrapped up with the customary BrewDog bite and imaginative twist.", "https://images.punkapi.com/v2/2.png", 4.1f))
        emit(beers)
    }
}