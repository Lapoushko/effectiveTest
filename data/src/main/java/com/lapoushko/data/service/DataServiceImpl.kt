package com.lapoushko.data.service

import android.content.Context
import com.lapoushko.network.entity.DataResponse
import com.lapoushko.network.service.DataService
import com.lapoushko.network.util.loadJSONFromAssets
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Lapoushko
 */
class DataServiceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : DataService{
    override suspend fun getResponse(): DataResponse? {
        return withContext(Dispatchers.IO){
            try {
                val json = loadJSONFromAssets(context, "mockdata.json")

                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                val jsonAdapter = moshi.adapter(DataResponse::class.java)

                jsonAdapter.fromJson(json ?: "")
            } catch (e: Exception) {
                DataResponse()
            }
        }
    }
}