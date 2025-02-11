package com.lapoushko.network.util

import android.content.Context
import com.lapoushko.network.entity.DataResponse
import com.lapoushko.network.service.DataService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import java.io.File
import java.nio.charset.Charset
import javax.inject.Inject

interface JsonDownloader {
    fun getResponse(): Flow<DataResponse?>
}

class JsonDownloaderImpl @Inject constructor(
    private val dataService: DataService,
    @ApplicationContext private val context: Context
) : JsonDownloader {

    override fun getResponse(): Flow<DataResponse?> = flow {
        downloadAndSaveJson()
        val response = parseJsonFile()
        emit(response)
    }

    private suspend fun downloadAndSaveJson(): File? {
        return withContext(Dispatchers.IO) {
            try {
                val response = dataService.downloadFile()
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        saveJsonToFile(body)
                    }
                } else {
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    private fun saveJsonToFile(body: ResponseBody): File? {
        return try {
            val file = File(context.getExternalFilesDir(null), FILE_NAME)
            body.byteStream().use { inputStream ->
                file.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            file
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun loadJSONFromFile(): String? {
        return try {
            val file = File(context.getExternalFilesDir(null), FILE_NAME)
            file.readText(Charset.forName("UTF-8"))
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun parseJsonFile(): DataResponse? {
        return try {
            val json = loadJSONFromFile()
            if (json != null) {
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

                val adapter = moshi.adapter(DataResponse::class.java)
                adapter.fromJson(json)
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    companion object {
        private const val FILE_NAME = "mockdata.json"
    }
}