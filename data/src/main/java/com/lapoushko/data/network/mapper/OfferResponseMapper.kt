package com.lapoushko.data.network.mapper

import com.lapoushko.data.network.entity.OfferResponse
import com.lapoushko.domain.entity.Offer
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface OfferResponseMapper{
    fun toDomain(offerResponse: OfferResponse) : Offer
}

class OfferResponseMapperImpl @Inject constructor() : OfferResponseMapper {
    override fun toDomain(offerResponse: OfferResponse): Offer {
        offerResponse.apply {
            return Offer(
                id = id ?: "",
                title = title ?: "",
                button = button?.text ?: "",
                link = link ?: ""
            )
        }
    }
}