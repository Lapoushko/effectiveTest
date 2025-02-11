package com.lapoushko.storage.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lapoushko.storage.entity.VacancyDb
import com.lapoushko.storage.util.ConstantsDatabase
import com.lapoushko.storage.util.CustomTypeConverters

/**
 * @author Lapoushko
 */
@Database(
    entities = [
        VacancyDb::class
    ],
    version = ConstantsDatabase.VERSION_DATABASE
)
@TypeConverters(CustomTypeConverters::class)
abstract class VacancyDatabase: RoomDatabase(){
    abstract fun VacancyDao(): VacancyDao
}