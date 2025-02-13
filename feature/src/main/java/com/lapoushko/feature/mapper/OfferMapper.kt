package com.lapoushko.feature.mapper

import android.net.Uri
import com.lapoushko.domain.entity.Offer
import com.lapoushko.feature.model.OfferItem
import javax.inject.Inject

/**
 * @author Lapoushko
 */
interface OfferMapper {
    fun toUi(offer: Offer): OfferItem
}

class OfferMapperImpl @Inject constructor(): OfferMapper {
    override fun toUi(offer: Offer): OfferItem {
        offer.apply {
            return OfferItem(
                id = id,
                title = title,
                button = button,
                link = Uri.parse(link)
            )
        }
    }
}