package com.lapoushko.storage.util

import androidx.room.TypeConverter
import com.lapoushko.storage.entity.AddressDb
import com.lapoushko.storage.entity.ExperienceDb

/**
 * @author Lapoushko
 */
class CustomTypeConverters {

    @TypeConverter
    fun convertAddressToString(addressDb: AddressDb?) : String {
        return listOf(addressDb?.town, addressDb?.street, addressDb?.house).joinToString(separator = SEPARATOR_KEY) { it ?: "" }
    }

    @TypeConverter
    fun convertStringToAddressDb(string: String?): AddressDb {
        val strings = string?.split(SEPARATOR_KEY)
        return AddressDb(town = strings!![0], street = strings[1], house = strings[2])
    }

    @TypeConverter
    fun convertExperienceToStrin(experienceDb: ExperienceDb?): String{
        return listOf(experienceDb?.text, experienceDb?.previewText).joinToString(separator = SEPARATOR_KEY) { it ?: "" }
    }

    @TypeConverter
    fun convertStringToExperienceDb(string: String?): ExperienceDb {
        val strings = string?.split(SEPARATOR_KEY)
        return ExperienceDb(text = strings!![0], previewText = strings[1])
    }

    companion object{
        private const val SEPARATOR_KEY = ", "
    }
}