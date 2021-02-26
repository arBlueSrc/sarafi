package com.arash.applikatask.localdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arash.applikatask.model.localdbmodel.DbModel
import java.util.*


@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(dbModel: DbModel)

    @Query("SELECT * FROM prices")
    fun getArz(): LiveData<List<DbModel>>

    @Query("SELECT * FROM prices WHERE kind =:kind")
    fun getFilterPrice(kind: String?): LiveData<List<DbModel>>

    @Query("DELETE FROM prices")
    suspend fun delete()
//
//    @Update
//    suspend fun updateTime(hourTableModel: HourTableModel)
//
//    @Query("SELECT * FROM Hour WHERE date BETWEEN :from AND :to")
//    fun findHoursBetweenDates(from: Date, to: Date): LiveData<List<HourTableModel>>
}