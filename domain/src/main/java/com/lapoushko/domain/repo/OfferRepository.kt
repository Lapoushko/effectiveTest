package com.lapoushko.domain.repo

import com.lapoushko.domain.entity.Offer

/**
 * @author Lapoushko
 */
interface OfferRepository {
    suspend fun getOffers() : List<Offer>
}