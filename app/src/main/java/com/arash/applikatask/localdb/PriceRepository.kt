package com.arash.applikatask.localdb

import android.content.Context
import androidx.lifecycle.LiveData
import com.arash.applikatask.model.localdbmodel.DbModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PriceRepository {

    companion object {

        var priceDatabase: PriceDatabase? = null

        var dbModel: LiveData<List<DbModel>>? = null

        fun initializeDB(context: Context): PriceDatabase {
            return PriceDatabase.getDataseClient(context)
        }

        fun insertData(
            context: Context,
            name: String,
            price: String,
            change: String,
            percent: String,
            kind: String
        ) {

            priceDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val price =
                    DbModel(0, name, price, change, percent, kind)
                priceDatabase!!.dao().InsertData(price)
            }

        }


        fun deleteData(
            context: Context,
        ) {

            priceDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                priceDatabase!!.dao().delete()
            }

        }

        fun getAll(
            context: Context
        ): LiveData<List<DbModel>>? {

            priceDatabase = initializeDB(context)

            dbModel = priceDatabase!!.dao().getArz()

            return dbModel
        }


        fun getFilterPrice(
            context: Context,
            kind: String
        ): LiveData<List<DbModel>>? {

            priceDatabase = initializeDB(context)

            dbModel = priceDatabase!!.dao().getFilterPrice(kind)

            return dbModel
        }


    }

}