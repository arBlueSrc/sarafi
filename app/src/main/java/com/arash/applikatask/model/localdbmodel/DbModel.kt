package com.arash.applikatask.model.localdbmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "prices")
data class DbModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int,

    @ColumnInfo(name = "name")
    var Name: String,

    @ColumnInfo(name = "price")
    var Price: String,

    @ColumnInfo(name = "change")
    var Change: String,

    @ColumnInfo(name = "percent")
    var Percent: String,

    @ColumnInfo(name = "kind")
    var Kind: String,

): Serializable

