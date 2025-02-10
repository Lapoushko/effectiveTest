package com.lapoushko.network.util

import android.content.Context
import java.io.InputStream
import java.nio.charset.Charset

/**
 * @author Lapoushko
 */
fun loadJSONFromAssets(context: Context, fileName: String): String? {
    var json: String? = null
    try {
        val inputStream: InputStream =
            context.assets.open(fileName)
        json = inputStream.bufferedReader(Charset.forName("UTF-8"))
            .use { it.readText() }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return json
}