package com.lapoushko.network.service

import com.lapoushko.network.entity.DataResponse

/**
 * @author Lapoushko
 */
interface DataService {
//    @GET("mockdata.json")
//    fun getData(): DataResponse

    suspend fun getResponse(): DataResponse?
}