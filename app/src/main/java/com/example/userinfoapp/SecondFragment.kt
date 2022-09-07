package com.example.userinfoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.userinfoapp.Viewmodel.CustomerViewModel
import com.example.userinfoapp.Viewmodel.MyViewModelFactory
import com.example.userinfoapp.data_controller.AppDatabase
import com.example.userinfoapp.databinding.FragmentSecondBinding
import com.example.userinfoapp.entities.Customer
import com.example.userinfoapp.repository.CustomerRepository
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 *
 * Display list of all customers
 *
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var viewModel: CustomerViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllValues()

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   fun getAllValues(){
       /**
        * Database -> repository -> Viewmodel Provider
        * Entity object
        * call method
        * TODO: Use Hilt DI
        */
       val db = AppDatabase.getDatabase(activity?.applicationContext!!)
       val repository = CustomerRepository(db.customerDAO())
       viewModel = ViewModelProvider(this, MyViewModelFactory(repository)).get(CustomerViewModel::class.java)

      viewModel.allCustomers.observe(viewLifecycleOwner){
         // recyclerview.submitList(it)
          for(i in it){
          Log.i("Customers" ,""+ i.cust_name )
              Log.i("Customers" ,""+ it.size)

          }
      }

   }
}