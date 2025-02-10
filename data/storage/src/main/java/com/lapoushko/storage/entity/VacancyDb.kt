package com.lapoushko.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lapoushko.storage.util.ConstantsDatabase
import com.lapoushko.storage.util.CustomTypeConverters

/**
 * @author Lapoushko
 */

@Entity(tableName = ConstantsDatabase.NAME_TABLE_GROUPS)
data class VacancyDb(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val idString: String?,
    val lookingNumber: Int?,
    val title: String?,
    @TypeConverters(CustomTypeConverters::class)
    val address: AddressDb?,
    val company: String?,
    @TypeConverters(CustomTypeConverters::class)
    val experience: ExperienceDb?,
    val publishDate: String?,
    val salary: String?,
    val isFavourite: Boolean?
)