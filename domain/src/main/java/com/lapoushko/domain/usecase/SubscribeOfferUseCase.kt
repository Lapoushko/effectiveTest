package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.Offer
import com.lapoushko.domain.repo.OfferRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeOfferUseCase{
    fun getOffers(): Flow<List<Offer>>
}

class SubscribeOfferUseCaseImpl @Inject constructor(
    private val repo: OfferRepository
):
    SubscribeOfferUseCase {
    override fun getOffers(): Flow<List<Offer>> {
        return repo.getOffers()
    }
}