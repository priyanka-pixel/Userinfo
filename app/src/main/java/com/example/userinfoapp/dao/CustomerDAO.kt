package com.example.userinfoapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userinfoapp.entities.Customer
import kotlinx.coroutines.flow.Flow

/**
 * Room library to understand: @Dao
 * Insert
 * Delete
 * Get all values
 */

@Dao
interface CustomerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCustomerData(vararg customer: Customer)

    @Query("SELECT * FROM customer")
    fun getAllCustomerData(): Flow<List<Customer>>


}