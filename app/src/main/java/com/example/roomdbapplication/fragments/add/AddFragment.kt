package com.example.roomdbapplication.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdbapplication.R
import com.example.roomdbapplication.model.User
import com.example.roomdbapplication.viewModel.UserViewMOdel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var  mUserViewModel: UserViewMOdel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewMOdel::class.java)

        view.btnAdd.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = edPersonFirstName.text.toString()
        val lastName = edPersonlastName.text.toString()
        val age = edPersonAge.text

        if(inputCheck(firstName,lastName,age)){
           val user = User(0,firstName,lastName,Integer.parseInt(age.toString()))

            //Add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_SHORT).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Please fill out all the details",Toast.LENGTH_SHORT).show()

        }

    }


    private fun inputCheck(firstName:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}