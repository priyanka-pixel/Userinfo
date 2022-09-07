package com.example.userinfoapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1 mark my class as data class
 * classname: Tablename
 * variables: column names
 * Room library to understand- annotations
 * @Entity
 *  @PrimaryKey
 *  @ColumnInfo
 */

@Entity
data class Customer(
    // columns
    @ColumnInfo(name = "name")val cust_name: String?,
    @ColumnInfo(name = "mobile")val cust_contact: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var cust_ID: Int = 0 // or foodId: Int? = null
}


