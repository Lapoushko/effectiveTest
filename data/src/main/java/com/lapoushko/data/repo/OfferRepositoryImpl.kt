package com.lapoushko.data.repo

import com.lapoushko.data.mapper.OfferResponseMapper
import com.lapoushko.domain.entity.Offer
import com.lapoushko.domain.repo.OfferRepository
import com.lapoushko.network.entity.OfferResponse
import com.lapoushko.network.service.DataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class OfferRepositoryImpl @Inject constructor(
    private val dataService: DataService,
    private val mapper: OfferResponseMapper
) : OfferRepository {
    override suspend fun getOffers(): List<Offer> {
        return withContext(Dispatchers.IO) {
            dataService.getResponse()?.offerResponses?.map {
                mapper.toDomain(
                    it ?: OfferResponse()
                )
            } ?: emptyList()
        }
    }
}