package com.lapoushko.domain.usecase

import com.lapoushko.domain.entity.Offer
import com.lapoushko.domain.repo.OfferRepository
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface SubscribeOfferUseCase{
    suspend fun getOffers(): List<Offer>
}

class SubscribeOfferUseCaseImpl @Inject constructor(
    private val repo: OfferRepository
):
    SubscribeOfferUseCase {
    override suspend fun getOffers(): List<Offer> {
        return repo.getOffers()
    }
}