package com.lapoushko.data.repo

import com.lapoushko.data.mapper.OfferResponseMapper
import com.lapoushko.domain.entity.Offer
import com.lapoushko.domain.repo.OfferRepository
import com.lapoushko.network.entity.OfferResponse
import com.lapoushko.network.util.JsonDownloader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class OfferRepositoryImpl @Inject constructor(
    private val jsonDownloader: JsonDownloader,
    private val mapper: OfferResponseMapper
) : OfferRepository {
    override fun getOffers(): Flow<List<Offer>> = flow {
        jsonDownloader.getResponse().collect { response ->
            val offers = response?.offerResponses?.map {
                mapper.toDomain(it ?: OfferResponse())
            } ?: emptyList()
            emit(offers)
        }
    }
}