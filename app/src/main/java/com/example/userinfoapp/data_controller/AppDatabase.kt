package com.example.userinfoapp.data_controller

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userinfoapp.dao.CustomerDAO
import com.example.userinfoapp.entities.Customer

/**
 * Room to understand: @Database(list of tables, database version)
 * Make it abstract
 *
 */

@Database(entities = [Customer:: class] , version = 2 )
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDAO(): CustomerDAO

    // static version of Java
    companion object{

       @Volatile
       private var INSTANCE: AppDatabase? = null

       fun getDatabase(context: Context): AppDatabase {

           return INSTANCE ?: synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   AppDatabase::class.java,
                   "CapitalThree6"
               ).build()
               INSTANCE =instance
               instance
           }
       }
    }

}