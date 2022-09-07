package com.example.userinfoapp

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.userinfoapp.Viewmodel.CustomerViewModel
import com.example.userinfoapp.Viewmodel.MyViewModelFactory
import com.example.userinfoapp.data_controller.AppDatabase
import com.example.userinfoapp.databinding.FragmentFirstBinding
import com.example.userinfoapp.entities.Customer
import com.example.userinfoapp.repository.CustomerRepository

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var viewModel: CustomerViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val name = binding.etName.text.toString()
//        val mobile= binding.etMobile.text.toString()


        binding.buttonFirst.setOnClickListener {
            insertDataFromUI(binding.etName.text.toString(), binding.etMobile.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun insertDataFromUI(name: String, mobile: String) {
        /**
         * Database -> repository -> Viewmodel Provider
         * Entity object
         * call method
         * TODO: Use Hilt DI
         */
        val db = AppDatabase.getDatabase(activity?.applicationContext!!)
        val repository = CustomerRepository(db.customerDAO())
        viewModel = ViewModelProvider(this, MyViewModelFactory(repository)).get(CustomerViewModel::class.java)

        val customer = Customer(  name, mobile)
        viewModel.insert(customer)
    }
}