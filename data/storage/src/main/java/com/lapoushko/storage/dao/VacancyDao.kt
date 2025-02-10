package com.lapoushko.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lapoushko.storage.entity.VacancyDb

/**
 * @author Lapoushko
 */
@Dao
interface VacancyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(vacancyDb: VacancyDb)

    @Query("DELETE FROM vacancy WHERE idString = :id")
    suspend fun deleteVacancy(id: String)

    @Query("SELECT * FROM vacancy WHERE idString = :id")
    suspend fun getVacancy(id: String) : VacancyDb?

    @Query("SELECT * FROM vacancy")
    suspend fun getVacancies() : List<VacancyDb>?
}