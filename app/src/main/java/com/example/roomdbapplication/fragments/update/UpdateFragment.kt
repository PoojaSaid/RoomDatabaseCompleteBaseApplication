package com.example.roomdbapplication.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.example.roomdbapplication.R
import com.example.roomdbapplication.model.User
import com.example.roomdbapplication.viewModel.UserViewMOdel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewMOdel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.secondName)
        view.updateAge_et.setText(args.currentUser.age.toString())

        mUserViewModel = ViewModelProvider(this).get(UserViewMOdel::class.java)

        view.btnUpdate.setOnClickListener {
            updateItem()
        }

        return view

    }

    private fun updateItem() {
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())

        if (inputCheck(firstName, lastName, updateAge_et.text)) {
            val updatedUser = User(args.currentUser.id, firstName, lastName, age)

            //Update Current User
            mUserViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(),"Updated data successfully",Toast.LENGTH_SHORT).show()

            //Navigate Fragment
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}