package com.lapoushko.data.network.repo

import android.content.Context
import com.lapoushko.data.network.entity.DataResponse
import com.lapoushko.data.network.entity.OfferResponse
import com.lapoushko.data.network.mapper.OfferResponseMapper
import com.lapoushko.data.network.util.loadJSONFromAssets
import com.lapoushko.domain.entity.Offer
import com.lapoushko.domain.repo.OfferRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class OfferRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val mapper: OfferResponseMapper
) : OfferRepository {
    override suspend fun getOffers(): List<Offer> {
        return withContext(Dispatchers.IO) {
            try {
                val json = loadJSONFromAssets(context, "mockdata.json")

                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                val jsonAdapter = moshi.adapter(DataResponse::class.java)

                jsonAdapter.fromJson(json ?: "")?.offerResponses?.map {
                    mapper.toDomain(
                        it ?: OfferResponse()
                    )
                } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}