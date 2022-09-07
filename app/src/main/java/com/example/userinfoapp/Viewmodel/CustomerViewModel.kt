package com.example.userinfoapp.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.entities.Customer
import com.example.userinfoapp.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Inject rep
 * Extend ViewModel
 *
 * - Inject
 * Hilt DI
 * ViewModelProvider
 *
 */
class CustomerViewModel(private val customerRepository: CustomerRepository): ViewModel() {
    // Insert
    /**
     * coroutines: Separate thread
     */
    fun insert(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        customerRepository.insertData(customer)
    }

    // List all data
    val allCustomers: LiveData<List<Customer>> = customerRepository.allCustomers.asLiveData()
}