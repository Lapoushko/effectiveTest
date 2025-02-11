package com.lapoushko.domain.repo

import com.lapoushko.domain.entity.Offer
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
interface OfferRepository {
    fun getOffers() : Flow<List<Offer>>
}