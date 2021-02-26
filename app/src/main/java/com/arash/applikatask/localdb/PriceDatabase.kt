package com.arash.applikatask.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arash.applikatask.model.localdbmodel.DbModel

@Database(entities = arrayOf(DbModel::class), version = 1, exportSchema = false)
abstract class PriceDatabase : RoomDatabase() {

    abstract fun dao(): DAOAccess

    companion  object {

        @Volatile
        private var INSTANCE: PriceDatabase? = null

        fun getDataseClient(context: Context): PriceDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, PriceDatabase::class.java, "DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}