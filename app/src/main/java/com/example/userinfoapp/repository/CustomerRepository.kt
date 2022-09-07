package com.example.userinfoapp.repository

import androidx.annotation.WorkerThread
import com.example.userinfoapp.dao.CustomerDAO
import com.example.userinfoapp.entities.Customer
import kotlinx.coroutines.flow.Flow

class CustomerRepository (private val customerDAO: CustomerDAO){

    // INSERT
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertData(customer: Customer){
        customerDAO.insertCustomerData(customer)
    }


    val allCustomers: Flow<List<Customer>> = customerDAO.getAllCustomerData()

    // Get List≠
}